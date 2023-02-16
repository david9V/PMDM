import React, { Component } from "react";
import PersonDataService from "../services/person.service";

export default class AddTutorial extends Component {
  constructor(props) {
    super(props);
    this.onChangeTitle = this.onChangeTitle.bind(this);
    this.onChangeDescription = this.onChangeDescription.bind(this);
    this.onChangePublished = this.onChangePublished.bind(this);
    this.addTutorial = this.addTutorial.bind(this);
    
    this.state = {
      currentTutorial: {
        id: null,
        title: "",
        description: "",
        published: false
      },
      message: "Add a tutorial :)"
    };
  }


  onChangeTitle(e) {
    const title = e.target.value;

    this.setState(function(prevState) {
      return {
        currentTutorial: {
          ...prevState.currentTutorial,
          title: title
        }
      };
    });
  }

  onChangeDescription(e) {
    const description = e.target.value;
    
    this.setState(prevState => ({
      currentTutorial: {
        ...prevState.currentTutorial,
        description: description
      }
    }));
  }

  onChangePublished(e) {
    const published = e.target.checked;
    
    this.setState(prevState => ({
      currentTutorial: {
        ...prevState.currentTutorial,
        published: published
      }
    }));
  }

  addTutorial() {
      PersonDataService.create(
        this.state.currentTutorial
      )
        .then(response => {
          console.log(response.data);
          this.setState({
            message: "The tutorial was added successfully!"
          });
        })
        .catch(e => {
          console.log(e);
        });
    
  }



  

  

  render() {
    const { currentTutorial } = this.state;

    return (
      <div>
      
          <div className="edit-form">
            <h4>Tutorial</h4>
            <form>
              <div className="form-group">
                <label htmlFor="title" name="title">Title</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  value={currentTutorial.title}
                  onChange={this.onChangeTitle}
                />
              </div>
              <div className="form-group">
                <label htmlFor="description">Description</label>
                <input
                  type="text"
                  className="form-control"
                  id="description"
                  value={currentTutorial.description}
                  onChange={this.onChangeDescription}
                />
              </div>

              <div className="form-group">
                <label htmlFor="published">Published</label>
                <input
                  type="checkbox"
                  className="published-form"
                  id="published"
                  checked={currentTutorial.published}
                  onChange={this.onChangePublished}
                />
              </div>
            </form>

            
            <button
              type="submit"
              className="badge badge-success"
              onClick={this.addTutorial}
            >
              Add
            </button>
            <br></br>
            <p>{this.state.message}</p>
          </div>
      </div>
    );
  }
}
