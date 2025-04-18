import React from 'react'
import './header.css'
import CTA from './CTA'
import ME from '../../assets/me.png'
import HeaderSocial from './HeaderSocial'
const Header = () => {
  return (
    <header>
      <div className="container header__container">
        <h5>Hello Im</h5>
        <h1>swimming pool</h1>
        <h5 className="text-light">STUDENT</h5>
        <CTA />
        <HeaderSocial />
        <div className="me">
          <img src={ME} alt="me" />
        </div>
        <a href='#contact' className='scroll__down'>最底部</a>
      </div>
    </header>
    )
}
export default Header