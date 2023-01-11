import React, { Component } from 'react';
import { Table } from 'react-bootstrap';

class Table_Example extends Component {
    constructor() {
        super()
    }

    renderData(data) {
        return (
            <tr>
                <td>{data[0].word}</td>
                <td>{data[0].phonetics[0].text}</td>
                <td>{data[0].meanings[0].definitions[0].definition}</td>
            </tr>
        )
    }

    render() {
        return (
            <Table responsive striped bordered hover size="sm">
                <thead>
                    <tr>
                        <th>Word</th>
                        <th>Phonetic</th>
                        <th>Meaning</th>
                    </tr>
                </thead>
                <tbody>
                    {this.props.data.map(this.renderData)}
                </tbody>
            </Table>)
    }
}

export default Table_Example;