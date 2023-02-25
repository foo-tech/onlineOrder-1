import React from "react";
import {useState} from "react";
class App extends React.component{
    state = {
        counter : 0,
    };

    handleClick = () => {
        const curCounter = this.state.counter;
        this.setState({
            counter : curCounter + 1,
        });
    };

    render = () => {
        return (
            <>
                <button onClick={this.handleClick}>Increase</button>
                <div>Now the value of counter is {this.state.counter}</div>
            </>
        )
    };

}