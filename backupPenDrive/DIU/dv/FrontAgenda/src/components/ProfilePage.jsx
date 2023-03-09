import React, { useContext } from "react";
import { UserContext } from "../providers/UserProvider";
import { navigate } from "@reach/router";
import { auth } from "../firebase";
import "../App.css";
const ProfilePage = () => {
  const user = useContext(UserContext);
  const { photoURL, displayName, email } = user;

  return (
      <div className="container perfil">
        <div className="row">
          <div className="card hovercard">
            <div className="cardheader">

            </div>
            <div className="avatar">
              <img alt="" src={photoURL} />
            </div>
            <div className="info">
              <div className="title">
                <p>{displayName}</p>
              </div>
              <div className="desc">{email}</div>
            </div>
          </div>
        </div>
        <div className="row">
        <button className = "btn btn-danger text-center btnSignOut mt-2" onClick = {() => {auth.signOut()}}>Sign out</button>
        </div>
      </div>
  )
};
/*
<div>
  <button className="btn btn-danger" onClick={() => { auth.signOut() }}>Sign out</button>
</div>
*/
export default ProfilePage;

