// JavaScript Document
const myHeading = document.querySelector('h1');
myHeading.textContent = 'About me!';
let myImage = document.querySelector('img');

myImage.onmouseover = function normal() {
    let mySrc = myImage.getAttribute('src');
    if(mySrc === 'images/gnl_col.png') {
      myImage.setAttribute('src','images/gnl_grey.png');
    } else {
      myImage.setAttribute('src','images/gnl_col.png');
    }
}

myImage.onmouseout = function reset() {
  let mySrc = myImage.getAttribute('src');
  if(mySrc === 'images/gnl_grey.png') {
    myImage.setAttribute('src','images/gnl_col.png');
  } else {
    myImage.setAttribute('src','images/gnl_col.png');
  }
}