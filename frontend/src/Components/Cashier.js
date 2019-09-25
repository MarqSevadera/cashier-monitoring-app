import React from 'react';
import {Paper , Grid, Typography, Button} from "@material-ui/core";
import axios from 'axios';
import Avatar from "@material-ui/core/Avatar";
import cashier from '../static/images/cashier.png';


const classes = {
    root: {
        width: "600px",
        backgroundColor: "#ffabdc"
    },
    text: {
        margin: "20px"
    },
    grid: {
        marginTop: "60px"
    },
    button: {
        margin: "20px 80px 20px 80px",
        width: "420px",
    },
    avatar:{
        margin: 10,
        width: 200,
        height: 200
    }
}



class Cashier extends React.Component{

    constructor(props){
        super(props);
        this.state = { data: { } }
    }

    handleChange = e => {
        let id = this.props.match.params.cashier_id;
        axios.post("http://localhost:8080/monitor/" + id).then(resp=>{
            console.log(resp.data);
            this.setState({data: resp.data})
            alert("Status Changed!");
        }).catch(err => {console.log(err)})
    }


    componentDidMount() {
        let id = this.props.match.params.cashier_id;
        console.log(id);
        axios.get("http://localhost:8080/monitor/" + id).then(resp=>{
            console.log(resp.data);
            this.setState({data: resp.data})
        }).catch(err => {console.log(err)})
    }

    render(){
        const {status , counterName , cashierName , totalCash} = this.state.data;
         return(
            <Grid container style={classes.grid} justify="center">
              <Paper elevation={15}style ={classes.root}>
                  <Typography align="center" style={classes.text} variant="h3">{counterName}</Typography>
                  <Grid container justify={"center"}>
                      <Avatar alt="Cashier" src={cashier} style={classes.avatar} />
                  </Grid>
                  <Typography color={"inherit"}style={classes.text} variant="h5">Status : {status}</Typography>
                  <Typography color={"inherit"}style={classes.text} variant="h5">Cashier Name : {cashierName}</Typography>
                  <Typography style={classes.text} variant="h5">Total Cash : {totalCash}</Typography>

                  <Button
                      onClick={this.handleChange}
                      style={classes.button} variant="contained"
                      color="primary">Change</Button>

              </Paper>
            </Grid>
        );
    }
}

export default Cashier;