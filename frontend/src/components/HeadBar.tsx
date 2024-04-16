import { useState } from "react"
import AddNote from "./AddNote";



export default function HeadBar(){

const [username, setUsername] = useState("username");

  return (
    <div id="headbar">
      <div>{username}</div>
      <div>
        <AddNote/>
      </div>
    </div>
  )
}