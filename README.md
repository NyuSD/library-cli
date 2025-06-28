# Library CLI

A console application that consumes the https://github.com/NyuSD/library-api 
answers four
questions via simple numbered prompts.

## 2. Run

```bash
./mvnw spring-boot:run
```

## 3. Menu

| Option | HTTP GET invoked                   | Printed output                    |
| ------ | ---------------------------------- | --------------------------------- |
| 1      | `/api/cities/{cityId}/branches`    | list of branches (name + address) |
| 2      | `/api/members/{memberId}/books`    | list of books (title + author)    |
| 3      | `/api/books/{bookId}/branches`     | branches stocking that book       |
| 4      | `/api/members/{memberId}/branches` | branches the member has visited   |
