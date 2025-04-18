import React from 'react'
import './about.css'
import ME from '../../assets/me-about.jpg'
import {BsAward}from 'react-icons/bs'
import {CiUser} from 'react-icons/ci'
import {AiOutlineFolderOpen} from 'react-icons/ai'
const About = () => {
  return (
    <section id='about'>
      <h5>Get to Know</h5>
      <h2>About Me</h2>
      <div className="coantainer about__container">
        <div className="about__content">
          <div className="about__cards">
            <article className='about__card'>
              <BsAward className='about__icon'/>
              <h5>Experience</h5>
              <small>no</small>

            </article>
            <article className='about__card'>
              <CiUser className='about__icon'/>
              <h5>grade</h5>
              <small>三年級</small>

            </article>
            <article className='about__card'>
              <AiOutlineFolderOpen className='about__icon'/>
              <h5>Project</h5>
              <small>持續累積中</small>
            </article>
          </div>
        </div>
      </div>
    </section>
  )
}

export default About