<h1>SpringDB</h1>
<p>Database start project.</p>

<h3>How to config when use to another project</h3>
<h4>pom.xml</h4>
<p>change Database Config.<p>

<h4>database.properties</h4>
<p>change properties.</p>

<h4>hibernate.cfg.xml</h4>
<ol>
   <li>change connection url.</li>
   <li>mapping entities.</li>
</ol>

<h4>hibernate4.xml</h4>
<p>change component scan.</p>

<h3>How to run generate schema for Development</h3>
<p>mvn hibernate3:hbm2ddl sql:execute</p> 