import { Link } from "react-router-dom";
import { useState } from "react";

async function addUser(name:string, password:string) {
  console.log(name);
  console.log(password);
  const userToAdd = {
    name,
    password
  };

  try {
    const addUserResponse = await fetch("/api/user/add", {
      method: "POST",
      body: JSON.stringify(userToAdd),
      headers: {
        "Content-Type": "application/json",
      },
    });

   
      const addedUser = await addUserResponse.json();
      
      console.log("registered: " + addedUser);
    
  } catch (error) {
    console.log(error);
  }
}

const Register = () => {
  const [name, setUserName] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    await addUser(name, password);

    setUserName("");
    setPassword("");
  };

  return (
    <form className="form" onSubmit={handleSubmit}>
      <h4>Register</h4>
      <div className="form-row">
        <label htmlFor="userName" className="form-label">
          Username
        </label>
        <input
        placeholder="Username"
          type="text"
          id="userName"
          name="userName"
          className="form-input"
          value={name}
          onChange={(e) => setUserName(e.target.value)}
          required
        />
      </div>
      <div className="form-row">
        <label htmlFor="password" className="form-label">
          Password
        </label>
        <input
        placeholder="Password"
          type="password"
          id="password"
          name="password"
          className="form-input"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
      </div>
      <button type="submit" className="btn">
        Submit
      </button>
      <p>
        Already a member?
        <Link to="/login" className="member-btn">
          Login
        </Link>
      </p>
    </form>
  );
};

export default Register;


