import { Canvas } from '@react-three/fiber'
import { Cappuccino } from './Cappuccino'
import { Environment, OrbitControls } from "@react-three/drei";
import { Suspense } from "react";
import './myCanva.css'

export default function MyCanva(){

  return (
    <div id='canva-container'>

    <Canvas>
        <Suspense fallback={null}>
          <Cappuccino/>
          <OrbitControls />
          <Environment preset="apartment" background />
        </Suspense>
      </Canvas>
    </div>
  )
}
