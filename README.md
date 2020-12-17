# social-media-auth

This project is for user authentication.

### API details

`POST - /authenticate`

Use the above API to authenticate the user with the ```username``` and ```password``` in the request body.

**_Sample request_**

`{"username":"user12","password":"pass12word"}`

**Valid credentials**

`1. {"username":"user12","password":"pass12word"}`

**Invalid credentials**

`1. {"username":"user12*","password":"pass12word"}`

`2. {"username":"us@er12","password":"pass12word"}`

`3. {"username":"","password":"pass12word"}`

`4. {"username":"user12","password":"pass12@word"}`

`5. {"username":"user12","password":"p#6$s12word"}`

`6. {"username":"user12","password":""}`

`7. {"username":"","password":""}`
