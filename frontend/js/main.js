
const booksList = document.querySelector(".books-list");
const buttonSendOrder = document.querySelector(".button-send-order");
const buttonChekDiscount = document.querySelector(".button-chek-discount");
const card = document.querySelector(".card");
const responseText = document.querySelector(".response-text");

let order = [];

const urlGet = "http://localhost:8080/api/books";
const urlPost = "http://localhost:8080/api/order";

async function getData(url) {
  const response = await fetch(url);

  if(!response.ok){
    throw new Error(`Ошибка по адресу ${url}, статус ошибки ${response.status}`);
  }

  return await response.json();
};

async function postData(url, data) {
  const response = await fetch(url, {
    method: 'POST', 
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(data) 
  });
  
  if(!response.ok){
    throw new Error(`Ошибка по адресу ${url}, статус ошибки ${response.status}`);
  }
  
  return await response.text(); 
}


function createBookList(books){

  books.forEach(function(item){
    const book = `<tr id="${item.id}"> 
      <td class="book-title">${item.title}</td>
      <td class="book-genre">${item.genre}</td>
      <td><button class="add-to-order">Добавить</button></td>
      </tr>`;
    
        
    booksList.insertAdjacentHTML('beforeend', book);

  });

  let buttons = document.querySelectorAll(".add-to-order");
  buttons.forEach((elem)=>{
    elem.addEventListener('click', addToOrder);
  })

}

function addToOrder(event){
  const target = event.target;
  const parent = target.parentElement.parentElement;
  const id = parent.id;
  const title = parent.querySelector(".book-title").textContent;
  const genre = parent.querySelector(".book-genre").textContent;
  if (target.classList.contains("active")){
    for (let i = 0; i < order.length; i++) {
      if (order[i].id == id){
        order.splice(i, 1); 
      }
    }
    target.innerText = "Добавить";
  }else{
    let book = {
      id: id,
      title: title,
      genre: genre
    };
    order.push(book);
    target.innerText = "Убрать";
  }
 
    target.classList.toggle("active");
  }


  function sendOrder(){
    
    if (order.length != 0){
      postData(urlPost, order)
      .then((data) => {
      responseText.value = data; 
      });
    }else{
      responseText.value = "Вы не выбрали ни одной книги";
    }
    
  }

  function checkDiscount(){
    getData(`http://localhost:8080/api/clients/${card.value}`).then(function(data){
      responseText.value = "Ваша скидка составляет " + data + " %";
      
    });
    
  }



function init(){
  getData(urlGet).then(function(data){
    createBookList(data);
  });

  buttonSendOrder.addEventListener('click', sendOrder);
  buttonChekDiscount.addEventListener('click', checkDiscount);
  
}

init();


