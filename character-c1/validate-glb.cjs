#!/usr/bin/env node
'use strict';
// Structural gate for a GLB asset. Never equate skeletal integrity with coach-approved motion.
const fs=require('node:fs'),assert=require('node:assert/strict');
function inspect(buf){
 assert.ok(Buffer.isBuffer(buf) && buf.length>=20,'GLB buffer needed');
 assert.equal(buf.toString('utf8',0,4),'glTF');
 assert.equal(buf.readUInt32LE(4),2,'glTF version 2');
 assert.equal(buf.readUInt32LE(8),buf.length,'GLB declared length');
 let off=12,data=null;
 while(off+8<=buf.length){
  const size=buf.readUInt32LE(off),type=buf.toString('utf8',off+4,off+8);off+=8;
  assert.ok(off+size<=buf.length,'GLB chunk fits');if(type==='JSON')data=JSON.parse(buf.toString('utf8',off,off+size).trim());off+=size;
 }
 assert.equal(off,buf.length);assert.ok(data,'JSON chunk present');
 const skins=data.skins||[],meshes=data.meshes||[],nodes=data.nodes||[],accessors=data.accessors||[];
 const ids=new Set(skins.flatMap(s=>s.joints||[]));
 const primitives=meshes.flatMap(m=>m.primitives||[]);
 const weighted=primitives.filter(p=>p.attributes?.JOINTS_0!==undefined && p.attributes?.WEIGHTS_0!==undefined);
 const vertices=primitives.reduce((n,p)=>n+(accessors[p.attributes?.POSITION]?.count||0),0);
 const missing=[...ids].filter(i=>i>=nodes.length);
 const info={fileBytes:buf.length,meshes:meshes.length,skins:skins.length,boneNodes:ids.size,weightedPrimitives:weighted.length,vertices,brokenBoneRefs:missing.length};
 return {info,baseRigStructuralPass:skins.length>0&&ids.size>=20&&weighted.length>0&&meshes.length>0&&missing.length===0,ownerA01Approval:false,qualifiedBoxingCoachReview:false};
}
function selftest(){
 const doc={asset:{version:'2.0'},nodes:[{}],skins:[{joints:[0]}],meshes:[{primitives:[{attributes:{POSITION:0,JOINTS_0:1,WEIGHTS_0:2}}]}],accessors:[{count:3},{count:3},{count:3}]};
 let j=Buffer.from(JSON.stringify(doc));j=Buffer.concat([j,Buffer.alloc((4-j.length%4)%4,32)]);
 const b=Buffer.alloc(20+j.length);b.write('glTF');b.writeUInt32LE(2,4);b.writeUInt32LE(b.length,8);b.writeUInt32LE(j.length,12);b.write('JSON',16);j.copy(b,20);
 const r=inspect(b);assert.equal(r.info.meshes,1);assert.equal(r.baseRigStructuralPass,false);assert.equal(r.qualifiedBoxingCoachReview,false);
 b.writeUInt32LE(b.length+2,8);assert.throws(()=>inspect(b));
 console.log('PASS: GLB binary structure and no false coaching certification');
}
if(require.main===module){if(process.argv[2]==='--selftest')selftest();else if(process.argv[2]){const x=inspect(fs.readFileSync(process.argv[2]));console.log(JSON.stringify(x,null,2));process.exit(x.baseRigStructuralPass?0:2);}else{console.error('usage: node validate-glb.cjs [--selftest|path/to/model.glb]');process.exit(64);}}
module.exports={inspect};
