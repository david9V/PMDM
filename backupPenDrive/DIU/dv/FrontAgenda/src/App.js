import React, { Component } from "react";
import { Switch, Route,Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import 'bootstrap/dist/css/bootstrap.css';
import "./App.css";
import PersonList from "./components/persons-list.component";
import PersonAdd from "./components/person-add-component";
import PersonEdit from "./components/person-edit-component";
import UserProvider from "./providers/UserProvider";

class App extends Component {
  
  render() {
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
            <Route exact path={"/"}  component={PersonList}/>
            <Route exact path="/add" component={PersonAdd} />
            <Route path="/persons/:id" component={PersonEdit} />
        </Switch>

        <UserProvider>
        </UserProvider>

        </div>
      </div>
      
    );
  }
}

export default App;
