import React from 'react'
import {ReactNavbar} from 'overlay-navbar'
import {MdAccountCircle} from "react-icons/md";
import {MdSearch} from "react-icons/md";
import {MdAddShoppingCart} from "react-icons/md";

const Header = () => {
  return <ReactNavbar 
  profileIcon={true}
  ProfileIconElement= {MdAccountCircle} 
  searchIcon={true}
  SearchIconElement={MdSearch}
  cartIcon={true}
  CartIconElement={MdAddShoppingCart}
  />;
}

export default Header
