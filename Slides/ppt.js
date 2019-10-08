let count = 0;
let original_width = 0;
let original_height = 0;
let original_x = 0;
let original_y = 0;
let original_mouse_x = 0;
let original_mouse_y = 0;
let element;
let resizer;
const minimum_size = 20;

createText = (img) => {
    let canvasMain = document.getElementById("canvas");
    let textAreaDiv = document.createElement("div");
    textAreaDiv.className = "textAreaDiv";
    textAreaDiv.id = count;

    textAreaDiv.style.top = (Math.floor(Math.random()*50)*5)+ "px";
    textAreaDiv.style.left = (Math.floor(Math.random()*60)*5)+ "px";

    let textArea = document.createElement("div");
    textArea.contentEditable = true;
    textArea.className = "textAreas";
    textArea.id = "textArea" + count;

    let textAreaDrag = document.createElement("div");
    textAreaDrag.id = "text" + count;

    if(typeof img != "undefined"){
        textAreaDiv.appendChild(img);
        textArea.contentEditable = "false";
        // let firstChild = document.getElementById("textAreaDiv").firstChild.nodeName;
        // firstChild.style.display = "none";
    }
    
    //textArea.innerHTML = '<img src="'+img+'" />'

    let textAreaTopLeft = document.createElement("div");
    textAreaTopLeft.className = "textArea TopLeft";
    textAreaTopLeft.id = count;
    textAreaTopLeft.contentEditable = false;
    //textAreaTopLeft.addEventListener("mousedown", getPosition("textAreaTopLeft" + count))
    textAreaTopLeft.addEventListener('mousedown', e => {
        e = e || window.event;
        const target = e.target || e.srcElement;
        getPosition(e, target.id,target.className)
    });

    let textAreaTopRight = document.createElement("div");
    textAreaTopRight.className = "textArea TopRight";
    textAreaTopRight.id = count;
    textAreaTopRight.contentEditable = false;
    textAreaTopRight.addEventListener('mousedown', e => {
        e = e || window.event;
        const target = e.target || e.srcElement;
        getPosition(e, target.id,target.className)
    });

    let textAreaBottomLeft = document.createElement("div");
    textAreaBottomLeft.className = "textArea BottomLeft";
    textAreaBottomLeft.id = count;
    textAreaBottomLeft.contentEditable = false;
    textAreaBottomLeft.addEventListener('mousedown', e => {
        e = e || window.event;
        const target = e.target || e.srcElement;
        getPosition(e, target.id,target.className)
    });

    let textAreaBottomRight = document.createElement("div");
    textAreaBottomRight.className = "textArea BottomRight";
    textAreaBottomRight.id = count;
    textAreaBottomRight.contentEditable = false;
    textAreaBottomRight.addEventListener('mousedown', e => {
        e = e || window.event;
        const target = e.target || e.srcElement;
        getPosition(e, target.id, target.className)
    });
    canvasMain.appendChild(textAreaDiv);
    textAreaDiv.appendChild(textArea);
    textAreaDiv.appendChild(textAreaTopLeft);
    textAreaDiv.appendChild(textAreaTopRight);
    textAreaDiv.appendChild(textAreaBottomLeft);
    textAreaDiv.appendChild(textAreaBottomRight);
    CKEDITOR.inline("textArea" + count,{enterMode:CKEDITOR.ENTER_BR});

    document.getElementById(count).onmousedown = function(e) {
        this.prevX = e.clientX;
        this.prevY = e.clientY;
        this.mouseDown = true;
        }
        document.getElementById(count).onmousemove = function(e) {
        if(this.mouseDown) {
        this.style.left = (Number(this.style.left.substring(0, this.style.left.length-2)) + (e.clientX - this.prevX)) + "px";
        this.style.top = (Number(this.style.top.substring(0, this.style.top.length-2)) + (e.clientY - this.prevY)) + "px";
        }
        this.prevX = e.clientX;
        this.prevY = e.clientY;
        }
        document.getElementById(count).onmouseup = function() {
        this.mouseDown = false;
        }

    canvasMain.appendChild(textAreaDrag);
    count++;
}

getFile = () => {
    let fileImage = document.getElementById("images").files;
    let canvasImage = document.getElementById("canvas");
    let image = document.createElement("img");
    image.style.width = "inherit";
    image.style.height = "inherit";
    image.src = window.URL.createObjectURL(fileImage[0]);
    image.setAttribute("src", window.URL.createObjectURL(fileImage[0]));
    // canvasImage.appendChild(image);
    createText(image);
}

function getPosition(e, id,className) {
    element = document.getElementsByClassName("textAreaDiv")[id];
    resizer = document.getElementsByClassName(className)[id];
    original_width = parseFloat(getComputedStyle(element).getPropertyValue('width').replace('px', ''));
    original_height = parseFloat(getComputedStyle(element).getPropertyValue('height').replace('px', ''));
    original_x = element.getBoundingClientRect().left - document.getElementById("canvas").getBoundingClientRect().left;
    original_y = element.getBoundingClientRect().top - document.getElementById("canvas").getBoundingClientRect().top;
    original_mouse_x = e.pageX;
    original_mouse_y = e.pageY;
    window.addEventListener('mousemove', resize)
    window.addEventListener('mouseup', stopResize)
  }

  function resize(e) {
    if (resizer.classList.contains('BottomRight')) {
      const width = original_width + (e.pageX - original_mouse_x);
      const height = original_height + (e.pageY - original_mouse_y)
      if (width > minimum_size) {
        element.style.width = width + 'px'
      }
      if (height > minimum_size) {
        element.style.height = height + 'px'
      }
    }
    else if (resizer.classList.contains('BottomLeft')) {
      const height = original_height + (e.pageY - original_mouse_y)
      const width = original_width - (e.pageX - original_mouse_x)
      if (height > minimum_size) {
        element.style.height = height + 'px'
      }
      if (width > minimum_size) {
        element.style.width = width + 'px'
        element.style.left = original_x + (e.pageX - original_mouse_x) + 'px'
      }
    }
    else if (resizer.classList.contains('TopRight')) {
      const width = original_width + (e.pageX - original_mouse_x)
      const height = original_height - (e.pageY - original_mouse_y)
      if (width > minimum_size) {
        element.style.width = width + 'px'
      }
      if (height > minimum_size) {
        element.style.height = height + 'px'
        element.style.top = original_y + (e.pageY - original_mouse_y) + 'px'
      }
    }
    else {
      const width = original_width - (e.pageX - original_mouse_x)
      const height = original_height - (e.pageY - original_mouse_y)
      if (width > minimum_size) {
        element.style.width = width + 'px'
        element.style.left = original_x + (e.pageX - original_mouse_x) + 'px'
      }
      if (height > minimum_size) {
        element.style.height = height + 'px'
        element.style.top = original_y + (e.pageY - original_mouse_y) + 'px'
      }
    }
  }
  
  function stopResize() {
    window.removeEventListener('mousemove', resize)
  }









