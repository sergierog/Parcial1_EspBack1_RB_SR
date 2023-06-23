db.createUser(
  {
    user: "root",
    pwd: "password",
    roles: [
          {
            role: "readWrite",
            db: "series"
          }
      ]
  }
);
db.createUser(
  {
    user: "root",
    pwd: "password",
    roles: [
          {
            role: "readWrite",
            db: "catalog"
          }
      ]
  }
);