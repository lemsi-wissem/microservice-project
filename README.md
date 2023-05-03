
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>Microservices Project Readme</h1>
<p>This project contains a set of microservices that work together to provide a notification and authentication system. The architecture of the project is based on a Docker Compose file that contains the following services:</p>

<ul>
	<li><strong>db:</strong> MySQL database service used by the authentication service.</li>
    <li><strong>mongo:</strong> Mongo database service used by the payment service</li>
	<li><strong>config-server:</strong> Spring Cloud Config server used to externalize the configuration for the services.</li>
	<li><strong>eureka-server:</strong> Service discovery server used by the services to register and discover each other.</li>
	<li><strong>notification-service:</strong> Service that sends notifications to users via email or SMS.</li>
    <li><strong>product-service:</strong> Service that handles products</li>
    <li><strong>stock-service:</strong> Service that handles stock</li>
    <li><strong>fournisseur-service:</strong> Service that handles fournisseur</li>
    <li><strong>payment-service:</strong> Service that handles payments</li>
	<li><strong>auth-service:</strong> Service that handles user authentication and authorization.</li>
	<li><strong>gateway:</strong> API gateway that provides a single entry point to the microservices.</li>
</ul>

<h2>Running the project</h2>

<p>Before running the project, you need to build the Docker images for each service. You can use the <code>docker build</code> command to build the images. For example, to build the image for the <code>auth-service</code>, you can run:</p>

<pre><code>docker build -t auth-service:latest /path/to/auth-service</code></pre>

<p>After building the images, you can run the project using the following command:</p>

<pre><code>docker-compose up</code></pre>

<p>This will start all the services defined in the Docker Compose file.</p>

<h2>Accessing the services</h2>

<p>Once the services are up and running, you can access them using the following URLs:</p>

<ul>
	<li><strong>Notification service:</strong> <a href="http://localhost:8081">http://localhost:8081</a></li>
	<li><strong>Product service:</strong> <a href="http://localhost:8082">http://localhost:8082</a></li>
	<li><strong>Fournisseur service:</strong> <a href="http://localhost:8084">http://localhost:8084</a></li>
	<li><strong>Stock service:</strong> <a href="http://localhost:8085">http://localhost:8085</a></li>
	<li><strong>Auth service:</strong> <a href="http://localhost:9898">http://localhost:9898</a></li>
	<li><strong>API gateway:</strong> <a href="http://localhost:8080">http://localhost:8080</a></li>
</ul>

<p>You can also access the Eureka server console at <a href="http://localhost:8761">http://localhost:8761</a> to see the registered services.</p>

<h2>Dependencies</h2>

<ul>
	<li>Docker version 20.10 or higher</li>
	<li>Docker Compose version 1.29 or higher</li>
</ul>

<h2>Contributing</h2>

<p>If you want to contribute to this project, please fork the repository and create a pull request with your changes. We welcome all contributions!</p>

</body>
</html>