import React, { useContext } from "react";
import { Router } from "@reach/router";
import SignIn from "./SignIn";
import UserProvider from "../providers/UserProvider";
import ProfilePage from "./ProfilePage";
import { UserContext } from "../providers/UserProvider";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import 'bootstrap/dist/css/bootstrap.css';
import "../App.css";
import PersonList from "./persons-list.component";
import PersonAdd from "./person-add-component";
import PersonEdit from "./person-edit-component";
/*
{user ?
      :
      }
*/
function Application() {
  const user = useContext(UserContext);
  console.log(user);
  return (
    
    <div>
    <nav className="navbar navbar-expand navbar-dark bg-success">
      <Link to={"/"} className="navbar-brand font-weight-bold">
        AGENDA
      </Link>
      <div className="navbar-nav mr-auto">
        <li className="nav-item font-weight-bold" >
        {user ? <Link to={"/add"} className="nav-link">
            Añadir contacto
          </Link>
          :
          <div></div>}

          
        </li>
      </div>
      <div className="navbar-nav ml-auto">
        <li className="nav-item">
        {user ? 
        <Link to={"/profile"} className="nav-link navbar-profile">
        <img src={user.photoURL} alt="" />
      </Link>  
      :
      <Link to={"/profile"} className="nav-link">
            Log-in    
      </Link>
      }
          
        </li>
      </div>
    </nav>

    <div className="container mt-3">
      
    <Switch>
        <Route exact path={"/"}  component={PersonList} />
        <Route exact path="/add" component={PersonAdd} />
        <Route path="/persons/:id" component={PersonEdit}/>
        {user ?
        <ProfilePage/>
        :
        <Route path="/profile" component={SignIn}/>}
    </Switch>

    </div>
  </div>
  );
}

export default Application;
