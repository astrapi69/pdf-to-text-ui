# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/swing-app-ui-template/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/swing-app-ui-template/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/swing-app-ui-template/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/swing-app-ui-template)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/swing-app-ui-template.svg?style=flat)](https://github.com/astrapi69/swing-app-ui-template/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/swing-app-ui-template/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/swing-app-ui-template)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/swing-app-ui-template.svg)](http://www.javadoc.io/doc/io.github.astrapi69/swing-app-ui-template)
[![MIT License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/swing-app-ui-template?branch=develop)](https://hitsofcode.com/github/astrapi69/swing-app-ui-template/view?branch=develop)

</div>

Template project for create java swing ui projects with izpack installer. A small documentation how to use this
template project in in the [wiki](https://github.com/astrapi69/swing-app-ui-template/wiki)

> Please support this project by simply putting a Github <a class="github-button" href="https://github.com/astrapi69/swing-app-ui-template" data-icon="octicon-star" aria-label="Star astrapi69/swing-app-ui-template on GitHub">
> Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project
> [![Donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making swing-app-ui-template great for all types of applications.

## Import dependencies to your project

<details>
  <summary>gradle (click to expand)</summary>

## gradle dependency

Replace the variable ${latestVersion} with the current latest version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/swing-app-ui-template/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/swing-app-ui-template)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of swing-app-ui-template:

define version in file gradle.properties

```
swingAppUiTemplateVersion=${latestVersion}
```

or in build.gradle ext area

```
    swingAppUiTemplateVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:swing-app-ui-template:$swingAppUiTemplateVersion")
```

# with new libs.versions.toml file

If you use the new libs.versions.toml file for new automatic catalog versions update

```
[versions]
swing-app-ui-template-version=${latestVersion}

[libraries]
swing-app-ui-template = { module = "io.github.astrapi69:swing-app-ui-template", version.ref = "swing-app-ui-template-version" }
```
then add the dependency to the dependencies area

```
    implementation libs.swing.app.ui.template
```
</details>

<details>
  <summary>Maven (click to expand)</summary>

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~swing-app-ui-template~~~) for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of swing-app-ui-template:

Then you can add the dependency to your dependencies:

    <properties>
        ...
```xml
        <!-- swing-app-ui-template version -->
        <swing-app-ui-template.version>${latestVersion}</swing-app-ui-template.version>
```
        ...
    </properties>
        ...
        <dependencies>
        ...
```xml
            <!-- swing-app-ui-template DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>swing-app-ui-template</artifactId>
                <version>${swing-app-ui-template.version}</version>
            </dependency>
```
        ...
        </dependencies>
</details>


<details>
  <summary>Snapshots (click to expand)</summary>

## 📸 Snapshots

[![Snapshot](https://img.shields.io/badge/dynamic/xml?url=https://oss.sonatype.org/service/local/repositories/snapshots/content/io/github/astrapi69/swing-app-ui-template/maven-metadata.xml&label=snapshot&color=red&query=.//versioning/latest)](https://oss.sonatype.org/content/repositories/snapshots/io/github/astrapi69/swing-app-ui-template/)

This section describes how to import snapshot versions into your project.
Add the following code snippet to your gradle file in the repositories section:
```
repositories {
   //...
```
```groovy
    maven {
        name "Sonatype Nexus Snapshots"
        url "https://oss.sonatype.org/content/repositories/snapshots"
        mavenContent {
            snapshotsOnly()
        }
    }
```
```
}
```
</details>

# Donations

This project is kept as an open source product and relies on contributions to remain being
developed. If you like this library, please consider a donation

over paypal:
<br>
<br>
<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386" target="_blank">
    <img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif"
        alt="PayPal this"
        title="PayPal – The safer, easier way to pay online!"
        style="border: none" />
</a>
<br>
<br>
or over bitcoin(BTC) with this address:

bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy.png"
alt="Donation Bitcoin Wallet" width="250"/>

or over FIO with this address:

FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop.png"
alt="Donation FIO Wallet" width="250"/>

or over Ethereum(ETH) with:

0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D.png"
alt="Donation Ethereum Wallet" width="250"/>

or over Ethereum Classic(ETC) with:

0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD.png"
alt="Donation Ethereum Classic Wallet" width="250"/>

or over Dogecoin(DOGE) with:

D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1.png"
alt="Donation Dogecoin Wallet" width="250"/>

or over Monero(XMR) with:

49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw.png"
alt="Donation Monero Wallet" width="250"/>

or over the donation buttons at the top.

## Semantic Versioning

The versions of swing-app-ui-template are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## What can i do to support this project

You can donate or contribute solve issues or pull request. Every support are welcome.

## Want to Help and improve it? ###

The source code for swing-app-ui-template are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/swing-app-ui-template/fork](https://github.com/astrapi69/swing-app-ui-template/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/swing-app-ui-template/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the swing-app-ui-template developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/astrapi69/swing-app-ui-template/issues).

## Similar projects

## Credits
