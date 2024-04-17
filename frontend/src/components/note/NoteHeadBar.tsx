import { useState } from "react"
import AddNote from "./AddNote";



export default function NoteHeadBar({reFetchNotes}){

const [username, setUsername] = useState("Username");

  return (

    <div id="note-headbar">
      <h2 id="note-user-name"><p id="note-user-name-spacer">{username}</p></h2>
      
      <div>
        <AddNote reFetchNotes={reFetchNotes}/>
      </div>
    </div>
  )
}