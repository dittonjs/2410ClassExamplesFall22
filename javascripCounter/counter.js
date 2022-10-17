let count = 0;

const counterDisplay = document.getElementById("counter-display");

function increment() {
  count ++;
  counterDisplay.innerText = `${count}`;
}

function decrement() {
  count --;
  counterDisplay.innerText = `${count}`;
}
