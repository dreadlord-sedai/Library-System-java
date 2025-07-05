# Z Library Management System

A modern Java Swing-based library management system with a beautiful FlatLaf UI.

## Features

- **Modern UI**: Beautiful FlatLaf-based interface with glassmorphism effects
- **User Authentication**: Secure login and registration system
- **Book Management**: Add, edit, delete, and search books
- **Member Management**: Manage library members
- **Book Issuing**: Issue books to members with due dates
- **Book Returns**: Process book returns with overdue tracking
- **Dashboard**: Overview of library statistics
- **Database Integration**: MySQL database backend

## Prerequisites

- Java 11 or higher
- MySQL 8.0 or higher
- Apache Ant (optional, for build automation)

## Setup Instructions

### 1. Database Setup

1. Start your MySQL server
2. Create the database and tables by running the SQL script:
   ```sql
   mysql -u root -p < database_schema.sql
   ```
   Or manually execute the contents of `database_schema.sql` in your MySQL client.

### 2. Database Configuration

Update the `zlibrary.properties` file with your database credentials:
```properties
db.url=jdbc:mysql://127.0.0.1:3306/zlibrary
db.username=your_username
db.password=your_password
lend.duration=14
```

### 3. Compile and Run

#### Option 1: Using Java Compiler (Recommended)
```bash
# Compile all source files
javac -cp "lib/*" -d build/classes src/lk/jiat/neolibrary/gui/*.java src/lk/jiat/neolibrary/component/*.java src/lk/jiat/neolibrary/dialog/*.java src/lk/jiat/neolibrary/entity/*.java src/lk/jiat/neolibrary/validation/*.java src/lk/jiat/neolibrary/connection/*.java src/lk/jiat/neolibrary/panel/*.java

# Run the application
java -cp "build/classes;lib/*" lk.jiat.neolibrary.gui.SplashScreen
```

#### Option 2: Using Apache Ant
```bash
# Clean and build
ant clean
ant jar

# Run the application
java -jar dist/zlibrary.jar
```

## Default Login Credentials

- **Email**: admin@zlibrary.com
- **Password**: Admin@123

## Application Flow

1. **Splash Screen**: Modern animated splash screen with Z Library branding
2. **Select Screen**: Choose between Login and Register
3. **Authentication**: Login with email and password
4. **Main Dashboard**: Access all library management features
   - Dashboard: Overview and statistics
   - Books: Manage book inventory
   - Members: Manage library members
   - Issue Book: Issue books to members
   - Return Book: Process book returns

## Project Structure

```
src/lk/jiat/neolibrary/
├── component/          # Custom UI components
├── connection/         # Database connection
├── dialog/            # Login/Register dialogs
├── entity/            # Data models and enums
├── gui/               # Main application screens
├── panel/             # Feature panels (Dashboard, Books, etc.)
└── validation/        # Input validation
```

## Dependencies

- **FlatLaf**: Modern look and feel for Swing
- **FlatLaf Extras**: Additional FlatLaf components
- **MySQL Connector**: Database connectivity
- **JCalendar**: Date picker component
- **JSVG**: SVG icon support
- **Swing Toast Notifications**: User notifications

## Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Ensure MySQL server is running
   - Verify database credentials in `zlibrary.properties`
   - Check if the `zlibrary` database exists

2. **Compilation Errors**
   - Ensure all JAR files are in the `lib/` directory
   - Use Java 11 or higher
   - Check classpath includes all dependencies

3. **UI Not Displaying Correctly**
   - Ensure FlatLaf JARs are in the classpath
   - Check if the application is running with the correct look and feel

### Password Requirements

The system requires passwords to meet the following criteria:
- 4-8 characters long
- At least one lowercase letter
- At least one uppercase letter
- At least one number
- At least one special character (@#$%^&+=)

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is licensed under the MIT License.

## Support

For support and questions, please contact the development team. 