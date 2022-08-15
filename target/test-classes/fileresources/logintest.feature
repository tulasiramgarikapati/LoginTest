Feature: Login
Scenario Outline: Validate Login Page
Given launch site using chromebrowser
When enter "<u>" as username
And enter "<p>" as password
And click submit
Then validate output for "<c>" as critiria
When close site
Examples:
| u         | p         | c          |
|           |           | bothblank  |
|           | tulasi123 | uidblank   |
| tulasi123 |           | pwdblank   |
| tulasi123 | tulasi123 | invalid    |
| tulasi    | tulasi    | valid      |