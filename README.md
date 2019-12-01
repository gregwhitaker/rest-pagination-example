# rest-pagination-example
An example of JDBC pagination, using limit and offset queries, in a RESTful webservice.

## Prerequisites
This example requires a running PostgreSQL database.

You can start an instance as a Docker container by running the following command:

    docker run -p 5432:5432 postgres

## Building the Example
Run the following command to build the example:

    ./gradlew clean build

## Running the Example
Follow the steps below to run the example:

1. Run the following command to start the example service:

        ./gradlew bootRun
        
2. Run the following command to query a list of all of the employees in the company:

        curl http://localhost:8080/employees
        
    If successful, you will receive 25 employee records from the database.
    
3. Adjust the `limit` and `offset` query parameters to paginate through the results:

        curl http://localhost:8080/employees?offset=25&limit=3
        
    If successful, you will retrieve employee records `26` - `28`:

        {
          "count": 3,
          "employees": [
            {
              "id": 26,
              "last_name": "Rodenborch",
              "first_name": "Skippie",
              "department": "Manufacturing",
              "phone": {
                "work": "+1-673-840-0729",
                "home": "+1-462-690-4108"
              },
              "email": {
                "work": "srodenborchp@dummycorp.com",
                "home": "srodenborchp@is.gd"
              },
              "addresses": {
                "work": {
                  "rel": "employee",
                  "type": "GET",
                  "href": "/employees/26/addresses/work"
                },
                "home": {
                  "rel": "employee",
                  "type": "GET",
                  "href": "/employees/26/addresses/home"
                }
              },
              "salary": "$144,661.34"
            },
            {
              "id": 27,
              "last_name": "Casari",
              "first_name": "Carlota",
              "department": "Accounting",
              "phone": {
                "work": "+1-233-245-3814",
                "home": "+1-911-995-9861"
              },
              "email": {
                "work": "ccasariq@dummycorp.com",
                "home": "ccasariq@webs.com"
              },
              "addresses": {
                "work": {
                  "rel": "employee",
                  "type": "GET",
                  "href": "/employees/27/addresses/work"
                },
                "home": {
                  "rel": "employee",
                  "type": "GET",
                  "href": "/employees/27/addresses/home"
                }
              },
              "salary": "$130,065.98"
            },
            {
              "id": 28,
              "last_name": "Marklin",
              "first_name": "Yasmin",
              "department": "Manufacturing",
              "phone": {
                "work": "+1-271-929-3657",
                "home": "+1-512-483-6872"
              },
              "email": {
                "work": "ymarklinr@dummycorp.com",
                "home": "ymarklinr@weebly.com"
              },
              "addresses": {
                "work": {
                  "rel": "employee",
                  "type": "GET",
                  "href": "/employees/28/addresses/work"
                },
                "home": {
                  "rel": "employee",
                  "type": "GET",
                  "href": "/employees/28/addresses/home"
                }
              },
              "salary": "$155,269.80"
            }
          ],
          "links": [
            {
              "rel": "prev",
              "type": "GET",
              "href": "/employees?offset=22&limit=3"
            },
            {
              "rel": "next",
              "type": "GET",
              "href": "/employees?offset=28&limit=3"
            }
          ]
        }

## License
MIT License

Copyright (c) 2019 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.