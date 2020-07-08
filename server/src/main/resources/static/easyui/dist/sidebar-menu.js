$.sidebarMenu = function (menu) {
  var animationSpeed = 300;

  $(menu).on('click', 'li a', function (e) {

    // console.log(e.target);
    if ($(".theme-left-layout ").hasClass('theme-nav-mini') && !$(e.target).parents().hasClass('treeview-menu')) {
      return false;
    }

    var $this = $(this);
    var checkElement = $this.next();

    if (checkElement.is('.treeview-menu') && checkElement.is(':visible')) {
      checkElement.slideUp(animationSpeed, function () {
        checkElement.removeClass('menu-open');
      });
      checkElement.parent("li").removeClass("active");
    }

    //If the menu is not visible
    else if ((checkElement.is('.treeview-menu')) && (!checkElement.is(':visible'))) {
      //Get the parent menu
      var parent = $this.parents('ul').first();
      //Close all open menus within the parent
      var ul = parent.find('ul:visible').slideUp(animationSpeed);
      //Remove the menu-open class from the parent
      ul.removeClass('menu-open');
      //Get the parent li
      var parent_li = $this.parent("li");

      //Open the target menu and add the menu-open class
      checkElement.slideDown(animationSpeed, function () {
        //Add the class active to the parent li
        checkElement.addClass('menu-open');
        parent.find('li.active').removeClass('active');
        parent_li.addClass('active');
      });
    } else {

      var tabTitle = $this.text();

      var url = $this.attr("gherf");
      console.log(url)
      // addTab(tabTitle, url);
      if ($(".theme-left-layout ").hasClass('theme-nav-mini')) {
        $(".treeview-menu.menu-open").css('display',"");
        $(".treeview-menu.menu-open").parent('li').removeClass('active');
        $(".treeview-menu.menu-open").removeClass('menu-open');
        
        $this.parents("ul").first().addClass("menu-open");
        $this.parents("ul").first().css("display","");
        console.log($this.parents("ul").first());
        $this.parents("ul").first().parent('li').addClass('active');
        $(".treeview-menu li").removeClass('active')
        $this.parent("li").addClass("active")
      } else {
        $(".treeview-menu li").removeClass('active')
        $this.parent("li").addClass("active")
      }

    }
    //if this isn't a link, prevent the page from being redirected
    if (checkElement.is('.treeview-menu')) {
      e.preventDefault();
    }
  });
}