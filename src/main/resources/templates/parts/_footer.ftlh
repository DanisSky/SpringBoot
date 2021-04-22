<footer>
    <div class="container">
        <header>
            <h2>Questions or comments?</h2>
            <p><b>Get in touch:</b></p>
        </header>
        <div class="flex-sm-column flex-md-row row d-flex">
            <section class="col-6">
                <form
                        action="/feedback"
                        method="post"
                        class="form"
                >
                    <input
                            class="col-9 mb-1"
                            name="name"
                            required
                            placeholder="Name"
                            type="text"
                    />
                    <input
                            class="col-9 mb-1"
                            name="email"
                            required
                            placeholder="Email"
                            type="text"
                    />
                    <textarea
                            class="col-9"
                            name="message"
                            required
                            rows="5"
                            placeholder="Message"
                    ></textarea>
                    <div class="col-12">
                        <button
                                type="submit"
                                value="Send"
                                class="btn btn-secondary form-button-submit button icon solid"
                        >
                            Send Message
                        </button>
                    </div>
                </form>
            </section>
            <div class="col-12-sm col-6">
                <section>
                    <div class="row">
                        <ul class="icons" style="list-style: none">
                            <p>some long text about feedback.</p>
                            <li class="icon solid fa-home">
                                1234 Somewhere Road<br />
                                Russia<br />
                                Kazan
                            </li>
                            <li class="icon solid fa-phone">8 (000) 000-0000</li>
                            <li class="icon solid fa-envelope">
                                <a href="https://github.com/DanisSky/Site">git@DanisSky</a>
                            </li>
                        </ul>
                    </div>
                </section>
            </div>
        </div>
    </div>
</footer>