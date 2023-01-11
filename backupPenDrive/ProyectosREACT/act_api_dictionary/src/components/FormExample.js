import React, { Component } from 'react';
import { Form, Button, Row, Col, FormGroup } from 'react-bootstrap';

class Form_Example extends Component {

    constructor() {
        super()
        this.state = {
            word: '',
        }
    }
  
    handleChange = event => {
        const value = event.target.value;
        this.setState({ word: value });
    }

    handleClick = event => {
        event.target.disabled = true;
        event.target.textContent = "Searching";
    }
    
    handleSubmit = event => {
        event.preventDefault();
        fetch(`https://api.dictionaryapi.dev/api/v2/entries/en/${this.state.word}`, {
            method: 'GET', 
            headers: {
              "Content-type": "application/json; charset=UTF-8"
            }
          })
          .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error(response.statusText);
            }
        })
        .then(data => { 
            this.props.passParams(data); 
        document.getElementById("boton").disabled = false;
        document.getElementById("boton").textContent = "Search";
        }).catch((response) => {
            console.log("holahola");
            window.alert("That word does not exist ;(");
            document.getElementById("boton").disabled = false;
            document.getElementById("boton").textContent = "Search";
        })
    }


    render() {
        return (
        <Form onSubmit={this.handleSubmit}>
            <Row>
                <Col>
                    <Form.Group>
                        <Form.Label>Word</Form.Label>
                        <Form.Control min="1" placeholder="Enter a word" name="word" value={this.state.userId} onChange={this.handleChange} />
                    </Form.Group>
                </Col>
            </Row>
            <Row>
                <FormGroup>
                    <Button type="submit" onClick={this.handleClick} id="boton">Search</Button>
                </FormGroup>
            </Row>
        </Form>)
    }

}

export default Form_Example;