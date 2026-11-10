const fs = require('node:fs');
const vm = require('node:vm');
const assert = require('node:assert/strict');
const html = fs.readFileSync(__dirname + '/academy_working_prototype.html', 'utf8');
const match = html.match(/<script>([\s\S]*?)<\/script>/);
assert.ok(match, 'Inline working script present');
const script = match[1];
let memory = {};
function openApp() {
  const root = {innerHTML:''}, listeners = {};
  const context = {
    localStorage: {getItem: k => memory[k] ?? null, setItem: (k,v) => memory[k] = v},
    performance, console, Date, Math, JSON, setInterval, clearInterval, setTimeout,
    window: {scrollTo() {}, addEventListener(name, f) {listeners['window-'+name]=f}},
    document: {hidden:false, getElementById: id => id === 'app' ? root : null, addEventListener(name,f) {listeners[name]=f}}
  };
  vm.createContext(context);
  vm.runInContext(script, context);
  return {root, context,
    click(dataset) {listeners.click({target:{closest:()=>({dataset})}})},
    go: (route,i) => context.window.__academyQA.navigate(route,i),
    state: () => context.window.__academyQA.state()};
}
const app = openApp();
assert.match(app.root.innerHTML,/WELCOME TO THE ACADEMY/);
app.click({pick:'goal',value:'Build coordination'});
app.click({saveProfile:'yes'});
app.go('lesson',0);
app.go('quiz');
app.click({answer:'0'});
assert.match(app.root.innerHTML,/Not quite yet/);
app.click({quizNext:'retry'});
app.click({answer:'1'});
assert.match(app.root.innerHTML,/Correct understanding/);
app.click({quizNext:'yes'});
app.click({answer:'0'});
app.click({quizNext:'yes'});
assert.ok(app.state().data.done.stance);
app.go('lesson',1);
assert.equal(app.state().lesson,1,'Footwork unlocked');
app.go('timer');
app.click({duration:'30'});
assert.equal(app.state().clock.left,30);
app.click({timer:'start'});
app.click({timer:'pause'});
assert.ok(app.state().clock.paused);
app.click({timer:'resume'});
assert.equal(app.state().clock.paused,false);
app.click({timer:'stop'});
app.click({timer:'confirmStop'});
assert.equal(app.state().data.demoSessions,0,'Premature stop not rewarded');
app.click({timer:'start'});
app.context.window.__academyQA.forceTimerDone();
assert.equal(app.state().data.demoSessions,1,'Complete demo tracked');
app.click({timer:'reset'});
const restored = openApp();
assert.ok(restored.state().data.done.stance,'Learning persisted');
assert.equal(restored.state().data.profile.goal,'Build coordination','Preference persisted');
app.go('lesson',0);
assert.match(app.root.innerHTML,/5-PHASE VISUAL EXPLAINER/,'Stance lesson has a real step-by-step motion studio');
assert.match(app.root.innerHTML,/Animated concept preview/,'Animation is clearly unverified');
app.click({motionStep:'4'});
assert.equal(app.state().motion.p,4,'Fifth storyboard pose selected');
app.click({motion:'play'});
assert.equal(app.state().motion.playing,true,'Play state active, restarting at first stage');
app.click({motion:'play'});
assert.equal(app.state().motion.playing,false,'Pause state works');
app.click({motionSpeed:'0.5'});
assert.equal(app.state().motion.speed,0.5,'Speed selection applied');
app.context.window.__academyQA.motionSeek(2.75);
assert.equal(app.state().motion.p,2.75,'Scrubber updates the interpolated pose');
app.go('home');
assert.equal(app.state().motion.playing,false,'Playback does not continue off-screen');
console.log('PASS: onboarding, feedback, unlocking, timer, cancellation, completion and persistence.');
