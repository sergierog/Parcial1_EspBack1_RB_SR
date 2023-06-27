db.createUser(
  {
    user: "root",
    pwd: "password",
    roles: [
          {
            role: "readWrite",
            db: "series"
          },
          {
            role: "readWrite",
            db: "catalog"
          }
      ]
  }
);