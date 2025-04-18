import React from 'react'
import './experience.css'
import {AiFillCheckSquare} from 'react-icons/ai'
const Experience = () => {
  return (
    <section id='expierence'>
      <h5>what Skill I Have</h5>
      <h2>my Experience</h2>

      <div className="container experience__container">
        <div className="experience__frontend">
          <h3>程式語言</h3>
          <div className="experience__content">
            <article className='experience__details'>
              <AiFillCheckSquare className='experience__details-icon' />
              <div>
              <h4>HTML</h4>
              <small className='text-light'>Experienced</small>
              </div>
            </article>
            <article className='experience__details'>
              <AiFillCheckSquare  className='experience__details-icon'/>
              <div>
                <h4>Python</h4>
                <small className='text-light'>Intermediate</small>
              </div>
              
            </article><article className='experience__details'>
              <AiFillCheckSquare  className='experience__details-icon' />
              <div>
                <h4>java</h4>
              <small className='text-light'>Intermediate</small>
              </div>
              
            </article><article className='experience__details'>
              <AiFillCheckSquare  className='experience__details-icon'/>
              <div>
                 <h4>C</h4>
              <small className='text-light'>Intermediate</small>
              </div>
             
            </article><article className='experience__details'>
              <AiFillCheckSquare  className='experience__details-icon'/>
              <div><h4>AI</h4>
              <small className='text-light'>few</small>
              </div>              
            </article><article className='experience__details'>
              <AiFillCheckSquare  className='experience__details-icon'/>
              <div>
               <h4>Kotlin</h4>
               <small className='text-light'>Intermediate</small> 
              </div>

            </article>
          </div>
        </div>
        {/*END OF FRONTED*/}
        <div className="experience__backend">
        <h3>前端</h3>
          <div className="experience__content">
            <article className='experience__details'>
              <AiFillCheckSquare   className='experience__details-icon'/>
              <div>
                <h4>Node JS</h4>
                <small className='text-light'>Intermediate</small>
              </div>

            </article>
            <article className='experience__details'>
              <AiFillCheckSquare  className='experience__details-icon'/>
              <div>
                <h4>MongoDB </h4>
                <small className='text-light'>Basic</small>
              </div>

                
            </article>
            <article className='experience__details'>
              <AiFillCheckSquare  className='experience__details-icon'/>
              <div>
                <h4>PHP</h4>
                <small className='text-light'>NO</small>
              </div>
              
            </article>
            <article className='experience__details'>
              <AiFillCheckSquare  className='experience__details-icon'/>
              <div>
                <h4>MySQL</h4>
                <small className='text-light'>Basic</small>
              </div>

             
            </article>
            <article className='experience__details'>
              <AiFillCheckSquare  className='experience__details-icon'/>
              <div>
                <h4>js</h4>
                <small className='text-light'>Basic</small>
              </div>
            </article>
            <article className='experience__details'>
              <AiFillCheckSquare  className='experience__details-icon'/>
              <div>
                <h4>React</h4>
                <small className='text-light'>Experienced</small>
              </div>
            </article>
          </div>
          </div>
      </div>
      </section>
    )
}

export default Experience