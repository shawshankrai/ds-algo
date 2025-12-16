spice_mix = set()
print(f"Initial spice mix id: {id(spice_mix)}")
spice_mix.add("Ginger")
spice_mix.add("cardamom")
print(f"After spice mix id: {id(spice_mix)}")

# ID remained same, even after changing it, no new id assigned - mutable
# Initial spice mix id: 4341532256
# After spice mix id: 4341532256
