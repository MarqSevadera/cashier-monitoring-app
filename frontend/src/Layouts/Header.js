import React from 'react';
import {AppBar,Toolbar} from "@material-ui/core";
import makeStyles from "@material-ui/core/styles/makeStyles";
import Typography from "@material-ui/core/Typography";
import CssBaseline from "@material-ui/core/CssBaseline";


const useStyles = makeStyles(theme=>({
    root : {
        padding:'15px',
        alignItems: 'center',
        backgroundColor: '#2d272e'
    }
}))
export default function Header(){
    const classes = useStyles();
    return(
        <div>
            <CssBaseline>
            <AppBar className={classes.root} position={"static"}>
                <Toolbar >
                    <Typography variant={"h4"}>
                        Cashier Monitoring System
                    </Typography>
                </Toolbar>
            </AppBar>
            </CssBaseline>
        </div>

    );
}