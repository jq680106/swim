import React from 'react'
import './footer.css'
import {AiFillFacebook} from 'react-icons/ai'
import {BsInstagram} from 'react-icons/bs'
import {BsTwitter} from 'react-icons/bs'
const Footer = () => {
  return (
    <footer>
      <a href='#' className='footer__logo'>SWIM</a>

      <ul className='permalinks'>
        <li><a href='#'>Home</a></li>
        <li><a href='#about'>About</a></li>
        <li><a href='#experiencce'>experiencce</a></li>
        {/* <li><a href='#services'>services</a></li>
        <li><a href='#portfolio'>Portfolio</a></li>
        <li><a href='#testimonials'>Testimonials</a></li> */}
        <li><a href='#contact'>contact</a></li>
      </ul>
      <div className="footer__socials">
        <a href='https://facebook.com'><AiFillFacebook /></a>
        <a href='https://instagram.com'><BsInstagram /></a>
        <a href='https://twitter.com'><BsTwitter /></a>
      </div>
      <div className="footer__copyright">
        <small>&copy; SWIM All rights reserved.</small>
      </div>
    </footer>
  )
}

export default Footer