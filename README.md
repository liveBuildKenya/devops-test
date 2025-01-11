# Documentation for Running and Deploying the Application

## 1. Build and Run Locally with Docker

- Ensure Docker is installed and running.
- Use the provided `docker-compose.yml` to build and run both the Angular and Spring Boot applications locally.
- Run the following command:
  ```bash
  docker-compose up --build
  ```

## 2. Deploy on Minikube

### Required Minikube Setup

1. Install Minikube and kubectl.
2. Start Minikube:
   ```bash
   minikube start
   ```
3. Set up kubectl context:
   ```bash
   kubectl config use-context minikube
   ```

### How to Access the Application

- Deploy the application using the provided Kubernetes YAML files:
  ```bash
  kubectl apply -f path_to_your_yml_files/
  ```
- Access the applications via Minikube's IP:
  ```bash
  minikube service <service-name> --url
  ```

## 3. CI/CD Pipeline with GitHub Actions

- The repository includes a GitHub Actions workflow configuration file (`.github/workflows/<file-name>.yml`).
- The pipeline automates testing, building, and deploying both applications.
  - Steps typically include:
    - Checkout code.
    - Set up Docker environment.
    - Build Docker images for the Angular and Spring Boot apps.
    - Push images to a container registry.
    - Deploy to Minikube or any other configured environment.

## 4. Assumptions, Decisions, and Challenges

- Assumed Docker and Kubernetes are already installed.
- Challenge: Ensuring compatibility between the Angular frontend and Spring Boot backend versions.
- The CI/CD pipeline uses GitHub Actions with Docker to simplify deployments.

