import { Canvas, useFrame } from '@react-three/fiber'
import { Cappuccino } from './Cappuccino'
import { CameraControls, Environment, OrbitControls, PerspectiveCamera } from "@react-three/drei";
import { Suspense, useReducer, useRef } from "react";
import './myCanva.css'
import { Camera } from 'three';

export default function MyCanva(){
 

  return (
    <div id='canva-container'>

    <Canvas camera={{position:[0,3,4]}}>
        <Suspense fallback={null}>
          <directionalLight position={[-6,2,2]}/>
          <directionalLight position={[6,2,2]}/>
          <ambientLight intensity={1.5}/>
          <Cappuccino/>
          <OrbitControls />
          {/* <Environment preset="apartment" background /> */}
        </Suspense>
      </Canvas>
    </div>
  )
}
