# SABiOx Tool (Full-Stack Application)

This repository contains the full-stack application for the SABiOx tool, consisting of a Spring Boot backend, a Vue/Quasar frontend, and a MySQL database.

The backend and database are managed via Docker Compose, while the frontend is run manually during development.

---

## Prerequisites

Ensure you have the following installed on your system:

* **Docker:** Docker Desktop or Docker Engine.
* **Docker Compose:** (Usually included with Docker Desktop).
* **Node.js** and **npm** (for running the frontend locally).

## Getting Started

### Run Backend + Database with Docker (Development Mode)

This is the recommended setup for development. The database and backend run in Docker, while the frontend runs locally on your machine.

#### 1. Start Backend and Database

Execute the following command from the root directory where `docker-compose.yml` is located:

```bash
docker compose up --build -d
```

This will start:
- **MySQL Database** on port `3307`
- **Spring Boot Backend** on port `8080`

The backend will wait for the database to be healthy before starting.

#### 2. Start the Frontend (in a separate terminal)

Navigate to the frontend directory:

```bash
cd front-sabiox_tool
```

Install dependencies (first time only):

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

The frontend will be available at `http://localhost:5173` (or the port shown in your terminal).

The frontend is pre-configured in `.env.local` to connect to the backend at `http://localhost:8080`.

#### 3. Access the Application

- **Frontend:** http://localhost:5173
- **Backend API:** http://localhost:8080
- **Database:** localhost:3307 (MySQL)

#### Stopping the Services

To stop the Docker services:

```bash
docker compose down
```

## Project Structure

- **back-sabiox_tool/**: Spring Boot backend application
- **front-sabiox_tool/**: Vue/Quasar frontend application
- **docker-compose.yml**: Orchestration file for backend and database
- **uploads/**: Directory for file uploads (avatars, etc.)

---

## Environment Variables

The backend uses environment variables defined in `docker-compose.yml`:
- `SPRING_DATASOURCE_URL`: Database connection string
- `SPRING_DATASOURCE_USERNAME`: Database username
- `SPRING_DATASOURCE_PASSWORD`: Database password

The frontend uses:
- `VITE_API_URL`: Backend API URL (defined in `.env.local`)
