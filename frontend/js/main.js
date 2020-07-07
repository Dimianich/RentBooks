
const booksList = document.querySelector(".books-list");

let books = [];
const url = "http://localhost:8080/api/books";

/*const getData = async function(url) {
  const response = await fetch(url);

  if(!response.ok){
    throw new Error(`Ошибка по адресу ${url}, статус ошибки ${response.status}`);
  }

  return await response.json();
};

*/


fetch(url)
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    console.log(data);
    //data.forEach(function(item) {
    //  console.log(item);
    //});
    //console.log(data.book[0].author);
    //books = data.book;
    console.log(data);
    createBookList(data);
    
/*
    data.book.forEach(function(item){
      const book = `<li id="${item.id}">
        <div class="book-title">${item.title}</div>
        <div class="book-genre">${item.genre}</div>
        <div class="book-author">${item.author}</div>
        <button class="add-to-cart">Добавить</button>
        </li>`;
      
        console.log(book);
    
      booksList.insertAdjacentHTML('beforeend', book);
    });

*/
  })
  .catch((error) => {
    console.log(error);
  });

/*
let response = await fetch(url);

if (response.ok) { // если HTTP-статус в диапазоне 200-299
  // получаем тело ответа (см. про этот метод ниже)
  let json = await response.json();
} else {
  alert("Ошибка HTTP: " + response.status);
}
*/

/*
const url = 'https://example.com/profile';
const data = { username: 'example' };

try {
  const response = await fetch(url, {
    method: 'POST', // или 'PUT'
    body: JSON.stringify(data), // данные могут быть 'строкой' или {объектом}!
    headers: {
      'Content-Type': 'application/json'
    }
  });
  const json = await response.json();
  console.log('Успех:', JSON.stringify(json));
} catch (error) {
  console.error('Ошибка:', error);
}
*/




function createBookList(books){

/*
  books.forEach(function(item) {
  console.log(item);
});
*/


  books.forEach(function(item){
    const book = `<li id="${item.id}">
      <div class="book-title">${item.title}</div>
      <div class="book-genre">${item.genre}</div>
      <button class="add-to-cart">Добавить</button>
      </li>`;
    
      console.log(book);
  
    booksList.insertAdjacentHTML('beforeend', book);
  });

}

/*
function init(){
  getData("./books.json").then(function(data){
    //data.book.forEach(createBookList);
    console.log(data);
  });
}

init();
*/

//createBookList();