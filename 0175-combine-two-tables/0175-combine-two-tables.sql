SELECT p.FirstName, p.LastName, a.city, a.State
FROM Person p
LEFT JOIN Address a
ON p.PersonId = a.PersonId;