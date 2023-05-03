import { useState } from 'react';
import { TextField, Button, Box, Link, Typography, Snackbar } from '@mui/material';
import axios from 'axios';

function Register() {
    const [name, setName] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [open, setOpen] = useState(false);
    const [message, setMessage] = useState('');
    const [severity, setSeverity] = useState('');

    const handleNameChange = (event) => {
        setName(event.target.value);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    const handleConfirmPasswordChange = (event) => {
        setConfirmPassword(event.target.value);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleSuccess = () => {
        setOpen(true);
        setMessage('Registration successful');
        setSeverity('success');
    };

    const handleError = (error) => {
        console.error(error);
        setOpen(true);
        setMessage('Registration failed');
        setSeverity('error');
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        if (password !== confirmPassword) {
            setOpen(true);
            setMessage('Passwords do not match');
            setSeverity('error');
            return;
        }
        try {
            const response = await axios.post('http://localhost:8080/auth/auth/register', {
                name,
                password,
            });
            console.log(response.data);

            handleSuccess();
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
                    label="Name"
                    variant="outlined"
                    fullWidth
                    value={name}
                    onChange={handleNameChange}
                />
                <TextField
                    label="Password"
                    type="password"
                    variant="outlined"
                    fullWidth
                    sx={{ mt: 2 }}
                    value={password}
                    onChange={handlePasswordChange}
                />
                <TextField
                    label="Confirm Password"
                    type="password"
                    variant="outlined"
                    fullWidth
                    sx={{ mt: 2 }}
                    value={confirmPassword}
                    onChange={handleConfirmPasswordChange}
                />
                <Button type="submit" variant="contained" fullWidth sx={{ mt: 2 }}>
                    Register
                </Button>
                <Box sx={{ mt: 2 }}>
                    <Typography align="center">
                        Already have an account?{' '}
                        <Link href="/" underline="hover">
                            Login
                        </Link>
                    </Typography>
                </Box>
            </Box>
            <Snackbar
                open={open}
                autoHideDuration={6000}
                onClose={handleClose}
                message={message}
                severity={severity}
            />
        </Box>
    );
}

export default Register;
