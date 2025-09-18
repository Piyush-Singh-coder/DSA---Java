import React from "react";
import { motion } from "framer-motion";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import { Sun, Moon, Menu, X, ArrowRight, ArrowUpRight, Instagram, Twitter, Linkedin, Dribbble, Mail, Phone, MapPin, ChevronRight, Star, LayoutGrid, Image as ImageIcon, Layers, Palette, Sparkles } from "lucide-react";

// --- Utility: theme toggle (uses data-theme on html) ---
const useTheme = () => {
  const [theme, setTheme] = React.useState(
    typeof window !== "undefined" && document.documentElement.classList.contains("dark")
      ? "dark"
      : "light"
  );
  React.useEffect(() => {
    if (theme === "dark") document.documentElement.classList.add("dark");
    else document.documentElement.classList.remove("dark");
  }, [theme]);
  return { theme, setTheme };
};

const navItems = [
  { label: "Work", href: "#work" },
  { label: "Services", href: "#services" },
  { label: "About", href: "#about" },
  { label: "Process", href: "#process" },
  { label: "Testimonials", href: "#testimonials" },
  { label: "Contact", href: "#contact" },
];

const projects = [
  {
    title: "E‑commerce Rebrand",
    tags: ["Branding", "UI/UX"],
    image:
      "https://images.unsplash.com/photo-1523275335684-37898b6baf30?q=80&w=1400&auto=format&fit=crop",
  },
  {
    title: "Mobile Banking App",
    tags: ["Product", "iOS"],
    image:
      "https://images.unsplash.com/photo-1556742400-b5b7c5121f2d?q=80&w=1400&auto=format&fit=crop",
  },
  {
    title: "SaaS Dashboard",
    tags: ["Design System", "Web"],
    image:
      "https://images.unsplash.com/photo-1551281044-8d8d0d8f1a3b?q=80&w=1400&auto=format&fit=crop",
  },
  {
    title: "Wellness Landing",
    tags: ["Marketing", "Web"],
    image:
      "https://images.unsplash.com/photo-1517245386807-bb43f82c33c4?q=80&w=1400&auto=format&fit=crop",
  },
  {
    title: "AR Furniture",
    tags: ["Product", "AR"],
    image:
      "https://images.unsplash.com/photo-1524758631624-e2822e304c36?q=80&w=1400&auto=format&fit=crop",
  },
  {
    title: "Edu Platform",
    tags: ["UX Research", "Web"],
    image:
      "https://images.unsplash.com/photo-1521737604893-d14cc237f11d?q=80&w=1400&auto=format&fit=crop",
  },
];

const services = [
  {
    icon: <LayoutGrid className="w-6 h-6" />,
    title: "Product Design",
    desc: "From ideation to high‑fidelity prototypes with a strong focus on usability.",
  },
  {
    icon: <Layers className="w-6 h-6" />,
    title: "Design Systems",
    desc: "Token‑based systems, components, and documentation for scale.",
  },
  {
    icon: <Palette className="w-6 h-6" />,
    title: "Brand Identity",
    desc: "Naming, visual language, and brand guidelines that stand out.",
  },
  {
    icon: <ImageIcon className="w-6 h-6" />,
    title: "Marketing Websites",
    desc: "Fast, responsive pages that convert and reflect your brand.",
  },
];

const stats = [
  { k: "70+", label: "Projects" },
  { k: "9y", label: "Experience" },
  { k: "24", label: "Awards" },
  { k: "12", label: "Clients" },
];

const testimonials = [
  {
    quote:
      "David elevated our product experience and shipped a robust design system in record time.",
    name: "Aisha Khan",
    role: "VP Product, Finoly",
    avatar: "https://i.pravatar.cc/100?img=5",
  },
  {
    quote:
      "A rare blend of strategy and craft. Our conversion lifted 34% after the redesign.",
    name: "Marco Silva",
    role: "CEO, Sproutly",
    avatar: "https://i.pravatar.cc/100?img=12",
  },
];

const steps = [
  { n: "01", title: "Discover", desc: "Stakeholder interviews, competitive audit, analytics review." },
  { n: "02", title: "Define", desc: "Problem framing, success metrics, roadmap & scope." },
  { n: "03", title: "Design", desc: "Flows, wireframes, UI, prototypes, and design system." },
  { n: "04", title: "Deliver", desc: "Dev handoff, QA support, and post‑launch iteration." },
];

function Header() {
  const { theme, setTheme } = useTheme();
  const [open, setOpen] = React.useState(false);
  return (
    <header className="sticky top-0 z-50 backdrop-blur-xl bg-white/70 dark:bg-neutral-900/60 border-b border-neutral-200/60 dark:border-neutral-800">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 py-4 flex items-center justify-between">
        <a href="#home" className="flex items-center gap-2">
          <div className="h-9 w-9 rounded-2xl bg-gradient-to-tr from-neutral-900 to-neutral-700 dark:from-white dark:to-neutral-300 grid place-items-center shadow">
            <span className="text-white dark:text-neutral-900 font-bold">D</span>
          </div>
          <span className="font-semibold text-lg">David</span>
        </a>
        <nav className="hidden md:flex items-center gap-6">
          {navItems.map((n) => (
            <a key={n.label} href={n.href} className="text-sm text-neutral-600 dark:text-neutral-300 hover:text-neutral-900 dark:hover:text-white transition">
              {n.label}
            </a>
          ))}
        </nav>
        <div className="hidden md:flex items-center gap-2">
          <Button className="rounded-2xl" variant="secondary">Let's talk</Button>
          <Button className="rounded-2xl" onClick={() => setTheme(theme === "dark" ? "light" : "dark")} aria-label="Toggle theme">
            {theme === "dark" ? <Sun className="w-4 h-4" /> : <Moon className="w-4 h-4" />}
          </Button>
        </div>
        <button className="md:hidden p-2" onClick={() => setOpen(!open)} aria-label="Toggle menu">
          {open ? <X /> : <Menu />}
        </button>
      </div>
      {open && (
        <div className="md:hidden border-t border-neutral-200 dark:border-neutral-800">
          <div className="px-4 py-3 flex flex-col gap-3">
            {navItems.map((n) => (
              <a key={n.label} href={n.href} className="text-neutral-700 dark:text-neutral-200" onClick={() => setOpen(false)}>
                {n.label}
              </a>
            ))}
            <div className="flex gap-2 pt-2">
              <Button className="rounded-2xl w-full" variant="secondary">Let's talk</Button>
              <Button className="rounded-2xl" onClick={() => setTheme(theme === "dark" ? "light" : "dark")}>{theme === "dark" ? <Sun className="w-4 h-4" /> : <Moon className="w-4 h-4" />}</Button>
            </div>
          </div>
        </div>
      )}
    </header>
  );
}

function Hero() {
  return (
    <section id="home" className="relative overflow-hidden">
      <div className="absolute inset-0 -z-10 opacity-20 dark:opacity-30 [mask-image:radial-gradient(60%_60%_at_50%_40%,black,transparent)]">
        <div className="absolute -top-24 -left-24 h-72 w-72 rounded-full bg-gradient-to-tr from-neutral-900 to-neutral-600 blur-3xl dark:from-white dark:to-neutral-300" />
        <div className="absolute -bottom-24 -right-24 h-72 w-72 rounded-full bg-gradient-to-tr from-neutral-900 to-neutral-600 blur-3xl dark:from-white dark:to-neutral-300" />
      </div>
      <div className="mx-auto max-w-7xl px-4 sm:px-6 py-20 md:py-28 grid md:grid-cols-2 items-center gap-10">
        <div>
          <Badge className="rounded-2xl py-1 px-3 text-xs" variant="secondary">Available for freelance</Badge>
          <h1 className="mt-4 text-4xl sm:text-5xl md:text-6xl font-bold leading-tight">
            Designer & Product Strategist crafting delightful experiences
          </h1>
          <p className="mt-4 text-neutral-600 dark:text-neutral-300 text-base md:text-lg max-w-xl">
            I help startups and brands ship world‑class products. From research to design systems, I partner end‑to‑end.
          </p>
          <div className="mt-6 flex flex-wrap gap-3">
            <Button className="rounded-2xl">View work <ArrowRight className="w-4 h-4 ml-2" /></Button>
            <Button className="rounded-2xl" variant="secondary">Download CV <ArrowUpRight className="w-4 h-4 ml-2" /></Button>
          </div>
          <div className="mt-10 grid grid-cols-4 gap-4 max-w-lg">
            {stats.map((s) => (
              <div key={s.label} className="text-center">
                <div className="text-2xl font-semibold">{s.k}</div>
                <div className="text-xs text-neutral-500 dark:text-neutral-400">{s.label}</div>
              </div>
            ))}
          </div>
        </div>
        <motion.div initial={{ opacity: 0, y: 20 }} whileInView={{ opacity: 1, y: 0 }} viewport={{ once: true }} transition={{ duration: 0.6 }} className="relative">
          <div className="relative rounded-3xl overflow-hidden shadow-2xl">
            <img
              src="https://images.unsplash.com/photo-1544005313-94ddf0286df2?q=80&w=1400&auto=format&fit=crop"
              alt="David Portrait"
              className="w-full h-[520px] object-cover"
            />
            <div className="absolute bottom-4 left-4 right-4 flex items-center justify-between bg-white/80 dark:bg-neutral-900/70 backdrop-blur rounded-2xl p-3">
              <div className="flex items-center gap-3">
                <Sparkles className="w-5 h-5" />
                <div>
                  <div className="text-sm font-medium">Currently crafting</div>
                  <div className="text-xs text-neutral-600 dark:text-neutral-400">Fintech Design System</div>
                </div>
              </div>
              <Badge className="rounded-xl">2025</Badge>
            </div>
          </div>
        </motion.div>
      </div>
    </section>
  );
}

function Services() {
  return (
    <section id="services" className="mx-auto max-w-7xl px-4 sm:px-6 py-16 md:py-24">
      <div className="flex items-end justify-between gap-6">
        <div>
          <h2 className="text-3xl md:text-4xl font-bold">Services</h2>
          <p className="mt-2 text-neutral-600 dark:text-neutral-300 max-w-2xl">I partner with teams to ship products that are beautiful, accessible, and measurable.</p>
        </div>
        <a href="#contact" className="hidden md:inline-flex items-center text-sm font-medium">Start a project <ChevronRight className="w-4 h-4" /></a>
      </div>
      <div className="mt-10 grid sm:grid-cols-2 lg:grid-cols-4 gap-6">
        {services.map((s) => (
          <Card key={s.title} className="rounded-2xl border-neutral-200 dark:border-neutral-800">
            <CardContent className="p-6">
              <div className="h-12 w-12 rounded-2xl bg-neutral-100 dark:bg-neutral-800 grid place-items-center mb-4">
                {s.icon}
              </div>
              <div className="font-semibold">{s.title}</div>
              <p className="mt-2 text-sm text-neutral-600 dark:text-neutral-400">{s.desc}</p>
              <Button variant="ghost" className="mt-4 px-0">Learn more <ArrowRight className="w-4 h-4 ml-2" /></Button>
            </CardContent>
          </Card>
        ))}
      </div>
    </section>
  );
}

function Work() {
  const [filter, setFilter] = React.useState("All");
  const categories = ["All", "Web", "Product", "Branding", "iOS", "AR"];
  const filtered = projects.filter((p) => filter === "All" || p.tags.includes(filter));
  return (
    <section id="work" className="mx-auto max-w-7xl px-4 sm:px-6 py-16 md:py-24">
      <div className="flex items-end justify-between gap-6">
        <div>
          <h2 className="text-3xl md:text-4xl font-bold">Selected Work</h2>
          <p className="mt-2 text-neutral-600 dark:text-neutral-300 max-w-2xl">A snapshot of recent projects across industries and platforms.</p>
        </div>
        <div className="hidden md:flex gap-2">
          {categories.map((c) => (
            <button key={c} onClick={() => setFilter(c)} className={`px-3 py-1.5 rounded-full text-sm border transition ${
              filter === c
                ? "bg-neutral-900 text-white dark:bg-white dark:text-neutral-900"
                : "border-neutral-200 dark:border-neutral-800 text-neutral-700 dark:text-neutral-300"
            }`}>
              {c}
            </button>
          ))}
        </div>
      </div>

      <div className="mt-6 md:hidden overflow-x-auto">
        <div className="flex gap-2 w-max">
          {categories.map((c) => (
            <button key={c} onClick={() => setFilter(c)} className={`px-3 py-1.5 rounded-full text-sm border transition ${
              filter === c
                ? "bg-neutral-900 text-white dark:bg-white dark:text-neutral-900"
                : "border-neutral-200 dark:border-neutral-800 text-neutral-700 dark:text-neutral-300"
            }`}>
              {c}
            </button>
          ))}
        </div>
      </div>

      <div className="mt-10 grid sm:grid-cols-2 lg:grid-cols-3 gap-6">
        {filtered.map((p) => (
          <motion.a
            key={p.title}
            href="#"
            initial={{ opacity: 0, y: 10 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ duration: 0.4 }}
            className="group rounded-2xl overflow-hidden border border-neutral-200 dark:border-neutral-800 hover:shadow-xl transition block"
          >
            <div className="aspect-[4/3] overflow-hidden">
              <img src={p.image} alt={p.title} className="w-full h-full object-cover group-hover:scale-105 transition" />
            </div>
            <div className="p-4 flex items-center justify-between">
              <div>
                <div className="font-medium">{p.title}</div>
                <div className="text-xs text-neutral-500 dark:text-neutral-400">{p.tags.join(" • ")}</div>
              </div>
              <ArrowUpRight className="w-5 h-5" />
            </div>
          </motion.a>
        ))}
      </div>
    </section>
  );
}

function About() {
  return (
    <section id="about" className="mx-auto max-w-7xl px-4 sm:px-6 py-16 md:py-24 grid md:grid-cols-2 gap-10 items-center">
      <div>
        <img
          src="https://images.unsplash.com/photo-1519389950473-47ba0277781c?q=80&w=1200&auto=format&fit=crop"
          alt="Studio"
          className="rounded-3xl shadow-xl"
        />
      </div>
      <div>
        <h2 className="text-3xl md:text-4xl font-bold">Human‑centered, outcome‑driven</h2>
        <p className="mt-4 text-neutral-600 dark:text-neutral-300">
          I combine research, strategy, and meticulous craft to build products people love. My approach balances business goals with user needs, and I thrive in fast‑moving environments.
        </p>
        <ul className="mt-6 grid sm:grid-cols-2 gap-3">
          {[
            "User research & testing",
            "Design systems",
            "Accessibility (WCAG)",
            "Rapid prototyping",
            "Cross‑functional leadership",
            "Metrics & experimentation",
          ].map((it) => (
            <li key={it} className="flex items-center gap-2 text-sm"><Star className="w-4 h-4" /> {it}</li>
          ))}
        </ul>
        <div className="mt-6 flex gap-3">
          <Button className="rounded-2xl">Get in touch</Button>
          <Button variant="secondary" className="rounded-2xl">Download CV</Button>
        </div>
      </div>
    </section>
  );
}

function Process() {
  return (
    <section id="process" className="mx-auto max-w-7xl px-4 sm:px-6 py-16 md:py-24">
      <h2 className="text-3xl md:text-4xl font-bold">Process</h2>
      <div className="mt-8 grid md:grid-cols-4 sm:grid-cols-2 gap-6">
        {steps.map((s) => (
          <Card key={s.n} className="rounded-2xl border-neutral-200 dark:border-neutral-800">
            <CardContent className="p-6">
              <div className="text-sm text-neutral-500 dark:text-neutral-400">{s.n}</div>
              <div className="mt-2 font-semibold">{s.title}</div>
              <p className="mt-2 text-sm text-neutral-600 dark:text-neutral-400">{s.desc}</p>
            </CardContent>
          </Card>
        ))}
      </div>
    </section>
  );
}

function Testimonials() {
  return (
    <section id="testimonials" className="mx-auto max-w-7xl px-4 sm:px-6 py-16 md:py-24">
      <h2 className="text-3xl md:text-4xl font-bold">What clients say</h2>
      <div className="mt-8 grid md:grid-cols-2 gap-6">
        {testimonials.map((t, i) => (
          <Card key={i} className="rounded-2xl border-neutral-200 dark:border-neutral-800">
            <CardContent className="p-6">
              <p className="text-lg leading-relaxed">“{t.quote}”</p>
              <div className="mt-4 flex items-center gap-3">
                <img src={t.avatar} alt={t.name} className="w-10 h-10 rounded-full" />
                <div>
                  <div className="font-medium">{t.name}</div>
                  <div className="text-xs text-neutral-500 dark:text-neutral-400">{t.role}</div>
                </div>
              </div>
            </CardContent>
          </Card>
        ))}
      </div>
    </section>
  );
}

function Contact() {
  return (
    <section id="contact" className="mx-auto max-w-7xl px-4 sm:px-6 py-16 md:py-24">
      <div className="grid lg:grid-cols-2 gap-10 items-start">
        <div>
          <h2 className="text-3xl md:text-4xl font-bold">Let's build something great</h2>
          <p className="mt-2 text-neutral-600 dark:text-neutral-300 max-w-xl">Tell me a bit about your project and I'll get back within 24 hours.</p>
          <div className="mt-6 space-y-3 text-sm">
            <div className="flex items-center gap-3"><Mail className="w-4 h-4" /> hello@david.design</div>
            <div className="flex items-center gap-3"><Phone className="w-4 h-4" /> +1 (555) 123‑4567</div>
            <div className="flex items-center gap-3"><MapPin className="w-4 h-4" /> Remote • GMT+5:30</div>
            <div className="flex items-center gap-3"><Instagram className="w-4 h-4" /> <a href="#" className="underline">@david.design</a></div>
          </div>
        </div>
        <Card className="rounded-2xl border-neutral-200 dark:border-neutral-800">
          <CardContent className="p-6">
            <form className="grid sm:grid-cols-2 gap-4">
              <div className="sm:col-span-1"><label className="text-sm">Name</label><Input placeholder="Your name" className="mt-1" /></div>
              <div className="sm:col-span-1"><label className="text-sm">Email</label><Input placeholder="you@company.com" className="mt-1" /></div>
              <div className="sm:col-span-2"><label className="text-sm">Project type</label><Input placeholder="Website, app, branding..." className="mt-1" /></div>
              <div className="sm:col-span-2"><label className="text-sm">Message</label><Textarea rows={5} placeholder="Tell me about your goals..." className="mt-1" /></div>
              <div className="sm:col-span-2"><Button className="rounded-2xl w-full">Send message</Button></div>
            </form>
          </CardContent>
        </Card>
      </div>
    </section>
  );
}

function Footer() {
  return (
    <footer className="border-t border-neutral-200 dark:border-neutral-800">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 py-10 flex flex-col md:flex-row items-center justify-between gap-4">
        <div className="text-sm text-neutral-600 dark:text-neutral-400">© {new Date().getFullYear()} David — All rights reserved.</div>
        <div className="flex items-center gap-4 text-sm">
          <a href="#" className="hover:underline">Privacy</a>
          <a href="#" className="hover:underline">Terms</a>
          <a href="#" className="hover:underline">Dribbble</a>
          <a href="#" className="hover:underline">LinkedIn</a>
        </div>
      </div>
    </footer>
  );
}

export default function PortfolioSite() {
  return (
    <div className="min-h-screen bg-white dark:bg-neutral-900 text-neutral-900 dark:text-white">
      <Header />
      <Hero />
      <Services />
      <Work />
      <About />
      <Process />
      <Testimonials />
      <Contact />
      <Footer />
    </div>
  );
}
