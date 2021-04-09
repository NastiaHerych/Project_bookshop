  let agree = function() {
    let agreed = document.getElementById('checkbox').checked;
    if (agreed) {
      let button = document.getElementById('loginbtn');
      button.disabled = false;
    } else {
      let button = document.getElementById('loginbtn');
      button.disabled = true;
    }
  }
  let check = function() {
    let pass = document.getElementById('password').value;
    let conf = document.getElementById('confirm_password').value;
    if (pass == '' || pass == undefined || pass == null || conf == '' || conf == undefined || conf == null) {
      document.getElementById('message').style.visibility = 'hidden';
      document.getElementById('confirm_password').style.boxShadow = '1px 0px 4px white';
      document.getElementById('password').style.boxShadow = '1px 0px 4px white';
    } else {
      if (document.getElementById('password').value ==
    document.getElementById('confirm_password').value) {
    document.getElementById('message').style.visibility = 'visible';
    document.getElementById('message').style.border = '1px solid #cccccc';
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'matching';
    document.getElementById('confirm_password').style.boxShadow = '1px 0px 4px white';
    document.getElementById('password').style.boxShadow = '1px 0px 4px white';
  } else {
    document.getElementById('message').style.visibility = 'visible';
    document.getElementById('message').style.border = '1px solid #cccccc';
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'not matching';
    document.getElementById('confirm_password').style.boxShadow = '1px 0px 4px red';
    document.getElementById('password').style.boxShadow = '1px 0px 4px red';
  }
  }
}
