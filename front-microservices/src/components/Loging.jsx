import {useState} from 'react';
import {TextField, Button, Box, Link, Typography, Snackbar} from '@mui/material';
import axios from 'axios';

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [open, setOpen] = useState(false);
    const [message, setMessage] = useState('');
    const [severity, setSeverity] = useState('');

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleSuccess = (token) => {
        localStorage.setItem('token', token);
        setOpen(true);
        setMessage('Login successful');
        setSeverity('success');
        //navigate to /send page after login
        window.location.href = '/send';
    };

    const handleError = (error) => {
        console.error(error);
        setOpen(true);
        setMessage('Login failed');
        setSeverity('error');
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/auth/auth/token', {
                username,
                password
            });
            console.log(response.data);

            // Save token and username to local storage
            localStorage.setItem('token', response.data);
            localStorage.setItem('username', username);
            handleSuccess(response.data);
        } catch (error) {
            handleError(error);
        }
    };


    return (
        <Box
            sx={{
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                minHeight: '100vh',
            }}
        >
            <Box
                component="form"
                onSubmit={handleSubmit}
                sx={{
                    display: 'flex',
                    flexDirection: 'column',
                    width: '100%',
                    maxWidth: 400,
                    p: 2,
                }}
            >
                <TextField
                    label="Username"
                    variant="outlined"
                    fullWidth
                    value={username}
                    onChange={handleUsernameChange}
                />
                <TextField
                    label="Password"
                    type="password"
                    variant="outlined"
                    fullWidth
                    sx={{mt: 2}}
                    value={password}
                    onChange={handlePasswordChange}
                />
                <Button type="submit" variant="contained" fullWidth sx={{mt: 2}}>
                    Login
                </Button>
                <Box sx={{mt: 2}}>
                    <Typography align="center">
                        Don't have an account?{' '}
                        <Link href="/register" underline="hover">
                            Register
                        </Link>
                    </Typography>
                </Box>
            </Box>
            <Snackbar open={open} autoHideDuration={6000} onClose={handleClose} message={message} severity={severity}/>
        </Box>
    );
}

export default Login;
