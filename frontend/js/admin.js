const booksList = document.querySelector(".books-list");
const bookTitle = document.querySelector(".title");
const bookGenre = document.querySelector(".genre");
const responseText = document.querySelector(".response-text");
const saveButton = document.querySelector(".save-button");



const urlGetPost = "http://localhost:8080/api/admin/books";


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
  
  return await response.status; 
}

async function deleteData(url) {
    const response = await fetch(url, {
      method: 'DELETE', 
    });
    
    if(!response.ok){
      throw new Error(`Ошибка по адресу ${url}, статус ошибки ${response.status}`);
    }
    
    return await response.status; 
  }


function createBookList(books){

  books.forEach(function(item){
    const book = `<tr id="${item.id}"> 
      <td class="book-title">${item.title}</td>
      <td class="book-genre">${item.genre}</td>
      <td><button class="remove-button">Удалить</button></td>
      </tr>`;
    
        
    booksList.insertAdjacentHTML('beforeend', book);

  });

  let buttons = document.querySelectorAll(".remove-button");
  buttons.forEach((elem)=>{
    elem.addEventListener('click', removeBook);
  })

}

function removeBook(event){
  const target = event.target;
  const parent = target.parentElement.parentElement;
  const id = parent.id;

  deleteData(`http://localhost:8080/api/admin/books/${id}`).then(function(data){
    if (data == 200){
        responseText.value = "Книга удалена";
    }
    

    updateData();
  
  });
 
  
  }


  function saveBook(){
    
    if(bookTitle.value != ""){
        let book = {
            title: bookTitle.value,
            genre: bookGenre.value
        }
        postData(urlGetPost, book)
        .then((data) => {
            if (data == 201){
                responseText.value = "Книга сохранена";
            }
        updateData(); 
        });
    }else{
      responseText.value = "Вы не ввели название книги";
    }
    
  }

function updateData(){
    getData(urlGetPost).then(function(data){
        createBookList(data);
      });
}  


function init(){
   
  updateData();

  saveButton.addEventListener('click', saveBook);
    
  
}

init();
