import { useState } from "react"
import AddNote from "./AddNote";



export default function NoteHeadBar(){

const [username, setUsername] = useState("Username");

  return (

    <div id="note-headbar">
      <h2 id="note-user-name">{username}</h2>
      
      <div>
        <AddNote/>
      </div>
    </div>
  )
}