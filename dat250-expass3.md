# Technical problems

# Screenshots

## Validation of MongoDB

![Validation failed](https://github.com/Neelzee/dat250/blob/main/a3/validation_failed.PNG?raw=true)

The validation failed, which is interesting.

## Results obtained during Experiment 1

### Insert

![Insert](https://github.com/Neelzee/dat250/blob/main/a3/insert.PNG?raw=true)

### Find

![Find](https://github.com/Neelzee/dat250/blob/main/a3/find.PNG?raw=true)

![Find](https://github.com/Neelzee/dat250/blob/main/a3/find_2.PNG?raw=true)

### Update

![Update](https://github.com/Neelzee/dat250/blob/main/a3/update.PNG?raw=true)

### Delete

![Delete](https://github.com/Neelzee/dat250/blob/main/a3/delete.PNG?raw=true)

### Bulkwrite

![Bulkwrite](https://github.com/Neelzee/dat250/blob/main/a3/bulkwrite.PNG?raw=true)

## Experiment 2 example working and Map-reduce operation

### Aggregate

![Aggregate](https://github.com/Neelzee/dat250/blob/main/a3/aggregate.PNG?raw=true)

### Map reduce

![Map Reduce](https://github.com/Neelzee/dat250/blob/main/a3/map_reduce.PNG?raw=true)

### Why use Map-reduce

In the example, I can now see the total price each costumer has. So, if it was a java object, with the price attribute,
what I did with map reduce, is the same as this psuedo-java code:

```java

HashMap<Customer, Int> price = new HashMap<>();

for (Customer c : Customer.AllCustomers) {
  if (price.getKeys().contains(c)) {
    price[c] += c.price;
  else {
    price.add(c, c.price);
  }
}
```

But the code in mongo is faster, since I dont have to transform a table-row into a java object.

# Issues

I used mongosh, and following the examples was a little difficult, since the copy/paste method did not work.

So for the larger examples, with more repetivive code, like the map reduce, I had too open notepad++,
and rewrite the code into a singleline, then I could easily copy paste the code.
