import React, { useContext } from "react";
import { Router } from "@reach/router";
import SignIn from "./SignIn";
import SignUp from "./SignUp";
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

function Application() {
  const user = useContext(UserContext);
  return (
    <div>
    <nav className="navbar navbar-expand navbar-dark bg-dark">
      <Link to={"/"} className="navbar-brand">
        Agenda
      </Link>
      <div className="navbar-nav mr-auto">
        <li className="nav-item">
          <Link to={"/add"} className="nav-link">
            Añadir
          </Link>
        </li>
      </div>
    </nav>

    <div className="container mt-3">
    <Switch>
        <Route exact path={"/"}  component={PersonList} />
        <Route exact path="/add" component={PersonAdd} />
        <Route path="/persons/:id" component={PersonEdit}/>
        <Route path="/sign-in" component={PersonEdit}/>
    </Switch>

    

    </div>
  </div>
  );
}

export default Application;
