import React, { Component } from "react";
import PersonDataService from "../services/person.service";
import { Link } from "react-router-dom";
import user from "./Application";
import { UserContext } from "../providers/UserProvider";


export default class PersonList extends Component {
  constructor(props) {
    super(props);
    this.refreshList = this.refreshList.bind(this);
    this.setActivePerson = this.setActivePerson.bind(this);
    this.removeAllPersons = this.removeAllPersons.bind(this);
    this.retrievePersons = this.retrievePersons.bind(this);
    this.deletePerson = this.deletePerson.bind(this);

    //Hacemos el bind de los métodos porque al usar estos métodos en gestores de eventos los componentes basados
    //en clases pierden el ámbito.
    this.state = {
      persons: [], //lista de personas
      3: null, //tutorial seleccionado de la lista
      currentIndex: -1,
      searchFirstName: "",
    };
  }
  //Cuando se carga el componente, se realiza la petición de personas a la API
  //El método retrievePersons provoca la actualización del estado, y por tanto la re-renderización del componente

  componentDidMount() {
    this.retrievePersons();
  }

  sendData(){
    this.props.parentCallback(this.state.persons.length);
    //preventDefault();  
  }


  retrievePersons() {
    PersonDataService.getAll()
      .then(response => {
        this.setState({
          persons: response.data
        });
        this.sendData();
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  refreshList() {
    this.retrievePersons();
    this.setState({
      currentPerson: null,
      currentIndex: -1,
      persons: []
    });
  }

  setActivePerson(tutorial, index) {
    this.setState({
      currentPerson: tutorial,
      currentIndex: index
    });
    console.log(this.context);
  }



  removeAllPersons() {
    PersonDataService.deleteAll()
      .then(response => {
        console.log(response.data);
        this.refreshList();
      })
      .catch(e => {
        console.log(e);
      });
  }

  deletePerson() {    
    PersonDataService.delete(this.state.currentPerson.id)
      .then(response => {
        console.log(response.data);
        this.refreshList();
      })
      .catch(e => {
        console.log(e);
      });
  }

  render() {
    const { searchFirstName, persons, currentPerson, currentIndex } = this.state;
    const user = this.context;
    //ponemos los distintos elementos del estado en variables para simplificar su acceso dentro del método
    return (
      
      <div className="list row">
       
        <div className="col-md-10">
          
          <div className="progress mt-2 mb-4">
            <div className="progress-bar progress-bar-striped bg-info" role="progressbar" style={{width: this.state.persons.length * 2 + "%"}} aria-valuemin="0" aria-valuemax="50">{this.state.persons.length * 2 + "%"} </div>
          </div> 
        </div>

        
        
        <div className="col-md-6">
          <h4 className="text-center font-weight-bold">Lista de contactos ({this.state.persons.length})</h4>

          <ul className="list-group">
            {/*El operador && lógico. Los dos elementos tienen que ser true, en este caso no vacio, para que se ejecute la sentencia */}
            {/*si persons está vacio , no se ejecuta el map*/}

            {persons &&
              persons.map((person, index) => (
                <li
              /* Cambiamos la clase del elemento de la lista seleccionado. Ponemos fondo azul*/
                  className={
                    "list-group-item text-center " +
                    (index === currentIndex ? "active" : "")
                  }
                  onClick={() => this.setActivePerson(person, index)}
                  key={index}
                >
                  {person.firstName}
                  {" "}
                  {person.lastName}
                </li>
              ))}
          </ul>
          {user ?
          <div className="text-center"> 
          <button type="submit"
           className="btn m-3 btn btn-sm btn-danger "
            onClick={() => { if (window.confirm('¿Está seguro de que desea borrar todos los contactos?'))
             this.removeAllPersons() } }>
              BORRAR TODO
              </button>
              </div>
          :
          null}

          
        </div>

        <div className="col-md-6">
          {/*Renderizado condicional. Si current person el null se dibuja lo de abajo. Si no,*/}
          {/*se dibuja "Please click on a person..." ver más abajo.*/}
          {currentPerson ? (
            <div className="ml-5">
              <h4 className="text-center font-weight-bold">Detalles</h4>
              <div className="mb-2">
                <label>
                  <strong>Nombre</strong>
                </label>{" "}
                {currentPerson.firstName}
              </div>
              <div className="mb-2">
                <label>
                  <strong>Apellidos:</strong>
                </label>{" "}
                {currentPerson.lastName}
              </div>
              <div className="mb-2">
                <label>
                  <strong>Calle:</strong>
                </label>{" "}
                {currentPerson.street}
              </div>
              <div className="mb-2">
                <label>
                  <strong>Código postal:</strong>
                </label>{" "}
                {currentPerson.postalCode}
              </div>
              <div className="mb-2">
                <label>
                  <strong>Ciudad:</strong>
                </label>{" "}
                {currentPerson.city}
              </div>
              <div className="mb-2">
                <label>
                  <strong>Fecha de nacimiento:</strong>
                </label>{" "}
                {currentPerson.birthday}
              </div>
            
              {user ? <div><Link
                //Como hemos incluido en el switch esta ruta, /persons/+id se renderizará el componente
                // persons cuando se pulse el enlace.
                to={"/persons/" + currentPerson.id}
                className="btn btn-primary mr-1"
              >
                Editar
              </Link>

              <Link
                //Como hemos incluido en el switch esta ruta, /persons/+id se renderizará el componente
                // persons cuando se pulse el enlace.
                className="btn btn-danger"
                to={"/"}
                onClick={this.deletePerson}
              >
                Eliminar
              </Link></div> : <p></p>
                
                }
              
            </div>
          ) : (
            
            <div>
              <br />
              <p></p>
            </div>
          )}
        </div>

      </div>
    );
  }
}
PersonList.contextType = UserContext;

