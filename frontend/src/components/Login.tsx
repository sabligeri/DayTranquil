import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";

async function addUser(name: string, password: string) {
  console.log(name);
  console.log(password);
  const userToAdd = {
    name,
    password,
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

export default function Login() {
  const [name, setUsername] = useState("");
  const [password, setUserPassword] = useState("");
  const [userId, setUserId] = useState(-1);

  const navigate = useNavigate();

  useEffect(() => {
    const id = JSON.parse(localStorage.getItem("userId")!);
    if (id > 0) {
      setUserId(id);
    }
  }, []);

  const handleRegister = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    await addUser(name, password);

    setUsername("");
    setUserPassword("");
  };

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();

    const user = {
      name,
      password,
    };

    try {
      const response = await fetch("/api/user/login", {
        method: "POST",
        body: JSON.stringify(user),
        headers: {
          "Content-Type": "application/json",
        },
      });
      console.log("1." + response);

      if (response.ok) {
        const responseUser = await response.json();
        localStorage.setItem("userId", JSON.stringify(responseUser.userID));
        setUserId(responseUser.userID);
        navigate("/main");
      } else {
        console.error("Failed to add the user");
      }
    } catch (error) {
      console.error(error);
    }
  }

  async function handleLogout(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setUserId(-1);
    localStorage.clear();
  }

  return userId > 0 ? (
    <form className="login-layout" onSubmit={(e) => handleLogout(e)}>
      <h2>You are logged in! </h2>
      <button type="submit" className="login-page-btn">
        Log out
      </button>
    </form>
  ) : (
    <div id="login-root">
    <div className="main">
      <input type="checkbox" id="chk" aria-hidden="true" />
      <div className="signup">
        <form onSubmit={(e) => handleRegister(e)}>
          <label htmlFor="chk" aria-hidden="true">
            Sign up
          </label>
          <input
            type="text"
            name="userName"
            onChange={(e) => setUsername(e.target.value)}
            value={name}
            placeholder="Username"
            required
            />
          <input
            type="password"
            onChange={(e) => setUserPassword(e.target.value)}
            value={password}
            placeholder="Password"
            />
          <button type="submit" className="login-page-btn">
            Sign up
          </button>
        </form>
      </div>
      <div className="login">
        <form onSubmit={(e) => handleSubmit(e)}  >
          <label htmlFor="chk" aria-hidden="true">
            Login
          </label>
          <input
            type="text"
            name="userName"
            onChange={(e) => setUsername(e.target.value)}
            value={name}
            placeholder="Username"
            required
            />
          <input
            type="password"
            onChange={(e) => setUserPassword(e.target.value)}
            value={password}
            placeholder="Password"
            />
          <button type="submit" className="login-page-btn">
            Log in
          </button>
        </form>
      </div>
    </div>
</div>

    //   <div class="main">
    // 	<input type="checkbox" id="chk" aria-hidden="true">

    // 		<div class="signup">
    // 			<form>
    // 				<label for="chk" aria-hidden="true">Sign up</label>
    // 				<input type="text" name="txt" placeholder="User name" required="">
    // 				<input type="email" name="email" placeholder="Email" required="">
    // 				<input type="password" name="pswd" placeholder="Password" required="">
    // 				<button>Sign up</button>
    // 			</form>
    // 		</div>

    // 		<div class="login">
    // 			<form>
    // 				<label for="chk" aria-hidden="true">Login</label>
    // 				<input type="email" name="email" placeholder="Email" required="">
    // 				<input type="password" name="pswd" placeholder="Password" required="">
    // 				<button>Login</button>
    // 			</form>
    // 		</div>
    // </div>
  );
}

{
  /* <p>Not a member?</p>
<p>
  <Link to="/register" className="login-link-btn">
    Sign up
  </Link>
</p> */
}
{
  /* <div class="main">  	
		<input type="checkbox" id="chk" aria-hidden="true">

			<div class="signup">
				<form>
					<label for="chk" aria-hidden="true">Sign up</label>
					<input type="text" name="txt" placeholder="User name" required="">
					<input type="email" name="email" placeholder="Email" required="">
					<input type="password" name="pswd" placeholder="Password" required="">
					<button>Sign up</button>
				</form>
			</div>

			<div class="login">
				<form>
					<label for="chk" aria-hidden="true">Login</label>
					<input type="email" name="email" placeholder="Email" required="">
					<input type="password" name="pswd" placeholder="Password" required="">
					<button>Login</button>
				</form>
			</div>
	</div> */
}
