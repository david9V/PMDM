import React, { useState } from "react";
import { Link } from "@reach/router";
import { auth } from "../firebase";


const SignIn = () => {

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);

  const signInWithEmailAndPasswordHandler = (event, email, password) => {
    event.preventDefault();
    auth.signInWithEmailAndPassword(email, password).catch(error => {
      setError("Error signing in with password and email!");
      console.error("Error signing in with password and email", error);
    });
  };

  const onChangeHandler = (event) => {
    const { name, value } = event.currentTarget;

    if (name === 'userEmail') {
      setEmail(value);
    }
    else if (name === 'userPassword') {
      setPassword(value);
    }
  };


  return (
    <div className="mt-8 ">
      <form>
        <div className="form-outline mb-4">
        <label className="form-label" htmlFor="userEmail">Email address</label>
          <input type="email" id="userEmail" name="userEmail" value={email} 
          className="form-control" placeholder="E.g: prueba@gmail.com" onChange={(event) => onChangeHandler(event)}/>
        </div>

        <div className="form-outline mb-4">
        <label className="form-label" htmlFor="userPassword">Password</label>
          <input type="password" name="userPassword"
            value={password}
            placeholder="Your Password"
            id="userPassword" className="form-control" onChange={(event) => onChangeHandler(event)}
            />
        </div>

        <button className="btn btn-primary btn-block mb-4" onClick={(event) => { signInWithEmailAndPasswordHandler(event, email, password) }} >Sign in</button>
      </form>
    </div>


  );
};

export default SignIn;
