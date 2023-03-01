import React, { Component } from "react";
import PersonDataService from "../services/person.service";
import { Link } from "react-router-dom";

export default class PersonList extends Component {
  constructor(props) {
    super(props);
    this.refreshList = this.refreshList.bind(this);
    this.setActivePerson = this.setActivePerson.bind(this);
    this.removeAllPersons = this.removeAllPersons.bind(this);
    this.onChangeSearchFirstName = this.onChangeSearchFirstName.bind(this);
    this.retrievePersons = this.retrievePersons.bind(this);
    this.searchFirstName = this.searchFirstName.bind(this);
    //Hacemos el bind de los métodos porque al usar estos métodos en gestores de eventos los componentes basados
    //en clases pierden el ámbito.
    this.state = {
      persons: [], //lista de personas
      3: null, //tutorial seleccionado de la lista
      currentIndex: -1,
      searchFirstName: ""
    };
  }
  //Cuando se carga el componente, se realiza la petición de personas a la API
  //El método retrievePersons provoca la actualización del estado, y por tanto la re-renderización del componente

  
  componentDidMount() {
    this.retrievePersons();
  }

  onChangeSearchFirstName(e) {
    const searchFirstName = e.target.value;

    this.setState({
      searchFirstName: searchFirstName
    });
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

  searchFirstName() {
    PersonDataService.get(this.state.searchFirstName)
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

  render() {
    const { searchFirstName, persons, currentPerson, currentIndex } = this.state;
    //ponemos los distintos elementos del estado en variables para simplificar su acceso dentro del método
    return (
      
      <div className="list row">
        <div className="col-md-10">
          <div className="input-group mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Buscar por nombre"
              value={searchFirstName}
              onChange={this.onChangeSearchFirstName}
            />
            <div className="input-group-append">
              <button
                className="btn btn-outline-secondary"
                type="button"
                onClick={this.searchFirstName}
              >
                Buscar
              </button>
            </div>
          </div>
        </div>
        
        <div className="col-md-6">
          <h4>Lista de personas</h4>

          <ul className="list-group">
            {/*El operador && lógico. Los dos elementos tienen que ser true, en este caso no vacio, para que se ejecute la sentencia */}
            {/*si persons está vacio , no se ejecuta el map*/}

            {persons &&
              persons.map((person, index) => (
                <li
              /* Cambiamos la clase del elemento de la lista seleccionado. Ponemos fondo azul*/
                  className={
                    "list-group-item " +
                    (index === currentIndex ? "active" : "")
                  }
                  onClick={() => this.setActivePerson(person, index)}
                  key={index}
                >
                  {person.firstName}
                </li>
              ))}
          </ul>

          <button
            className="m-3 btn btn-sm btn-danger"
            onClick={this.removeAllPersons}
          >
            Remove All
          </button>
        </div>
        <div className="col-md-6">
          {/*Renderizado condicional. Si current person el null se dibuja lo de abajo. Si no,*/}
          {/*se dibuja "Please click on a person..." ver más abajo.*/}
          {currentPerson ? (
            <div>
              <h4>Detalles</h4>
              <div>
                <label>
                  <strong>Nombre</strong>
                </label>{" "}
                {currentPerson.firstName}
              </div>
              <div>
                <label>
                  <strong>Apellidos:</strong>
                </label>{" "}
                {currentPerson.lastName}
              </div>
              <div>
                <label>
                  <strong>Calle:</strong>
                </label>{" "}
                {currentPerson.street}
              </div>
              <div>
                <label>
                  <strong>Código postal:</strong>
                </label>{" "}
                {currentPerson.postalCode}
              </div>
              <div>
                <label>
                  <strong>Ciudad:</strong>
                </label>{" "}
                {currentPerson.city}
              </div>
              <div>
                <label>
                  <strong>Fecha de nacimiento:</strong>
                </label>{" "}
                {currentPerson.birthday}
              </div>
              
              <div>
                <label>
                  <strong>Status:</strong>
                </label>{" "}
                {/* renderizado condicional */}
                {currentPerson.published ? "Published" : "Pending"}
              </div>
              

              <Link
                //Como hemos incluido en el switch esta ruta, /persons/+id se renderizará el componente
                // persons cuando se pulse el enlace.
                to={"/persons/" + currentPerson.id}
                className="badge badge-warning"
              >
                Editar
              </Link>
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
